package com.cao.rjtx_homework6.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rjtx_user6")
public class User {

    @Id
    @Column(length = 20,name = "id")
    private String id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public User() {
    }

    public User(String id, String name, String gender, String tel) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.tel = tel;
    }
}
