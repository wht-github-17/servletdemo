package com.wht.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    static Connection con;
    static PreparedStatement pst;

    public static Connection getCon() {
        Context context = null;
       // ComboPooledDataSource ds = null;
        DataSource ds=null;
        try {
            context = new InitialContext();
       //     ds = (ComboPooledDataSource) context.lookup("java:comp/env/jdbc/ums");
         ds=(DataSource) context.lookup("java:comp/env/jdbc/ums");
            con = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static int executeUpdate(String sql,Object... para){
        int row=0;
        getCon();
        try {
            pst=con.prepareStatement(sql);
            if(para!=null){
                for(int i=0;i<para.length;i++){
                    pst.setObject((i+1),para[i]);
                }
            }
            row=pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return row;
    }
    public static List<Map<String,Object>> executeQuery(String sql,Object...para){
        List<Map<String,Object>> list=new ArrayList<>();
        getCon();
        try {
            pst=con.prepareStatement(sql);
            if(para!=null){
                for(int i=0;i<para.length;i++){
                    pst.setObject((i+1),para[i]);
                }
            }
            ResultSet rs=pst.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
            while(rs.next()){
                Map<String,Object> map=new HashMap<>();
                for(int i=0;i<columnCount;i++){
                    map.put(rsmd.getColumnName((i+1)),rs.getObject(i+1));
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
