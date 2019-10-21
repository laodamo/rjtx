package com.cao.rjtx_homework6.configure;

import com.cao.rjtx_homework6.dao.UserDao;

import com.cao.rjtx_homework6.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class AddHandlerInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AddHandlerInterceptor.class);
    @Autowired
    UserDao userDao;

    private static Map<String,String > map;

    private  List<String> errors = new ArrayList<String>();

    static {
        map = new HashMap<String,String>();
        map.put("134","中国移动");
        map.put("135","中国移动");
        map.put("136","中国移动");
        map.put("137","中国移动");
        map.put("138","中国移动");
        map.put("139","中国移动");
        map.put("150","中国移动");
        map.put("151","中国移动");
        map.put("152","中国移动");
        map.put("157","中国移动");
        map.put("158","中国移动");
        map.put("159","中国移动");
        map.put("182","中国移动");
        map.put("187","中国移动");
        map.put("188","中国移动");
        map.put("147","中国移动");
        map.put("130","中国联通");
        map.put("131","中国联通");
        map.put("132","中国联通");
        map.put("155","中国联通");
        map.put("156","中国联通");
        map.put("186","中国联通");
        map.put("145","中国联通");
        map.put("133","中国电信");
        map.put("153","中国电信");
        map.put("189","中国电信");

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String gender = request.getParameter("gender");
        String tel = request.getParameter("tel");
        String name = request.getParameter("name");
        User user = new User(id, name, gender, tel);
        logger.info("准备用户验证..."+user);
        boolean flag = true;
        errors.clear();
        boolean a = checkRepeat(id);
        boolean b = checkId(user);
        boolean c = checkTel(tel);
        if (a&&b&&c) {
            logger.info("用户验证成功...");

            return true;
        } else {
            logger.info("用户验证失败...");

            request.setAttribute("error",errors);
            request.getRequestDispatcher("/add").forward(request,response);
            return false;
        }
     }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        modelAndView.addObject("error",errors);
    }


    //检查id
    private boolean checkId(User user){
        boolean flag = true;
        if(user.getId().length()==18){
            logger.info("身份证验证成功！");
            if(Integer.parseInt(String.valueOf(user.getId().charAt(16)))%2!=Integer.parseInt(user.getGender())){
                flag = false;
                errors.add("性别与身份证上信息不符！");
                logger.info("性别与身份证上信息不符！");
            }else {
                logger.info("性别验证成功！");
            }
        }else{
            flag = false;
            errors.add("身份证号位数不正确");
            logger.info("身份证号位数不正确");
        }
        return flag;
    }

//


    //检查用户是否已注册
    private boolean checkRepeat(String id){
        boolean flag = true;
        User user = userDao.getUser(id);
        if(user!=null){
            flag = false;
            errors.add("该用户已存在！");
            logger.info("该注册用户已存在！");
        }else
            logger.info("重复验证成功");
        return flag;
    }

    //检查电话号码是否合理
    private boolean checkTel(String s){
        boolean flag = true;
        if(s.length()>3){
            String substring = s.substring(0, 3);
            if(s.length()!=11||map.get(substring)==null){
                logger.info("电话号格式不正确！");
                errors.add("电话号格式不正确！");
                flag = false;
            }else {
                logger.info("电话格式验证通过！");
            }
        }else{
                errors.add("电话号码小于三位数！");
                logger.info("电话号码小于三位数！");
        }
        return flag;
    }
}
