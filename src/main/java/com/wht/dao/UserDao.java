package com.wht.dao;

import com.wht.domain.User;
import com.wht.util.DBUtil;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserDao {
    public List<User> select(){
        String sql="select * from user";
        List<Map<String,Object>> list=DBUtil.executeQuery(sql,null);
        List<User> users=select(list);
        return users;
    }
    public int updateState(int id){
        String sql="update user set state=1 where id=?";
       return DBUtil.executeUpdate(sql,id);
    }
    public User selectByActiveCode(String activeCode) {
        User u=null;
        String sql = "select * from user where activeCode=?";
        List<Map<String, Object>> list = DBUtil.executeQuery(sql, activeCode);
        List<User> users=select(list);
        if(users.size()>0){
            u=users.get(0);
        }
        return u;
    }

    public int insert(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,?,default,?,now())";
        Object[] para = {user.getUserName(), user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRole()};
        return DBUtil.executeUpdate(sql, para);

    }

    public User selectByNameAndPassword(User user) {
        User u = null;
        String sql = "select * from user where username=? and password=?";
        Object[] para = {user.getUserName(), user.getPassword()};
        List<Map<String, Object>> list = DBUtil.executeQuery(sql, para);
        List<User> users=select(list);
        if(users.size()>0){
            u=users.get(0);
        }
//        if (users.size() > 0) {
//            u = new User();
//            u.setActiveCode(Optional.ofNullable(users.get(0).get("activeCode")).toString());
//            u.setEmail(Optional.ofNullable(users.get(0).get("email")).toString());
//            u.setGender(Optional.ofNullable(users.get(0).get("gender")).toString());
//            u.setId(Integer.parseInt(users.get(0).get("id").toString()));
//            u.setIntroduce(Optional.ofNullable(users.get(0).get("introduce")).toString());
//            u.setPassword(Optional.ofNullable(users.get(0).get("password")).toString());
//            u.setRegistTime(LocalDate.parse(users.get(0).get("registTime").toString()));
//            u.setRole(Optional.ofNullable(users.get(0).get("role")).toString());
//            u.setState(Integer.parseInt(users.get(0).get("state").toString()));
//            u.setTelephone(Optional.ofNullable(users.get(0).get("telephone")).toString());
//            u.setUserName(Optional.ofNullable(users.get(0).get("username")).toString());
//        }
        System.out.println(u.toString());
        return u;
    }

    private List<User> select(List<Map<String, Object>> list) {

        List<User> users = null;
        if (list.size() > 0) {

            users = new ArrayList<>();
            for (Map map : list) {
                User u = new User();
                u.setActiveCode(Optional.ofNullable(map.get("activeCode")).toString());
                u.setEmail(Optional.ofNullable(map.get("email")).toString());
                u.setGender(Optional.ofNullable(map.get("gender")).toString());
                u.setId(Integer.parseInt(map.get("id").toString()));
                u.setIntroduce(Optional.ofNullable(map.get("introduce")).toString());
                u.setPassword(Optional.ofNullable(map.get("password")).toString());
                u.setRegistTime(LocalDate.parse(map.get("registTime").toString()));
                u.setRole(Optional.ofNullable(map.get("role")).toString());
                u.setState(Integer.parseInt(map.get("state").toString()));
                u.setTelephone(Optional.ofNullable(map.get("telephone")).toString());
                u.setUserName(Optional.ofNullable(map.get("username")).toString());
                users.add(u);
            }
        }
        return users;
    }
}
