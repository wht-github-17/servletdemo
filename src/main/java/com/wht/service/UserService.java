package com.wht.service;

import com.wht.dao.UserDao;
import com.wht.domain.User;
import com.wht.util.MailUtils;

import javax.mail.MessagingException;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    //查询用户
    public List<User> getAll(){
        return userDao.select();
    }

    //登录
    public User login(User user) {
        return userDao.selectByNameAndPassword(user);
    }
//注册
    public boolean register(User user) {
        boolean result=false;
        int row=userDao.insert(user);
        if(row>0){
            //发送激活邮件
            String emailMsg="感谢您注册网上书城，单击<a href='http://localhost:8080/servletdemo_war/activeUser?activeCode="+
                    user.getActiveCode()+"'>&nbsp;激活&nbsp;</a>后使用。"+
                    "<br/>为保障您的账户安全，请在24小时内完成激活操作";
            try {
                MailUtils.sendMail(user.getEmail(),emailMsg);
                result=true;
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    //按激活码查用户
    public User getUser(String activeCode){
        return userDao.selectByActiveCode(activeCode);
    }
    //修改用户为激活状态
    public boolean activeUser(int id){
        boolean result=false;
        int row=userDao.updateState(id);
        if(row>0){
            result=true;
        }
        return result;

    }

}
