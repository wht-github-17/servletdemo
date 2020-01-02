package com.wht.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
1.implements Serializable
2.属性类型要使用封装类类型
3.标识符要符合命名规范
4.get,set
5.构造方法，无参的，全参的
6.重写toString
*/
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String gender;
    private String email;
    private String telephone;
    private String introduce;
    private String activeCode;
    private Integer state;
    private String role;
    private LocalDate registTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", introduce='" + introduce + '\'' +
                ", activeCode='" + activeCode + '\'' +
                ", state=" + state +
                ", role='" + role + '\'' +
                ", registTime=" + registTime +
                '}';
    }

    public User() {
    }

    public User(Integer id, String userName, String password, String gender, String email, String telephone, String introduce, String activeCode, Integer state, String role, LocalDate registTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.telephone = telephone;
        this.introduce = introduce;
        this.activeCode = activeCode;
        this.state = state;
        this.role = role;
        this.registTime = registTime;
    }

    public LocalDate getRegistTime() {
        return registTime;
    }

    public void setRegistTime(LocalDate registTime) {
        this.registTime = registTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
