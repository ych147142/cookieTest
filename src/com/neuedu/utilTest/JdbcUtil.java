package com.neuedu.utilTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PWD = "123456";
    static{
        try {
            /*映射 驱动*/
            Class.forName("com.mysql.jdbc.Driver");
           /* new Driver();*/
        /*} catch (SQLException e) {
            e.printStackTrace();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义方法 创建链接
    public static Connection getConnection(){
        Connection conn= null;
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //定义关闭方法
    public static void close(ResultSet re, PreparedStatement sta, Connection conn){
        if(re != null){
            try {
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //定义方法  增删改
    public static int executeUpdate(String sql,Object... obj){
        int a = 0;
        Connection conn = null ;
        PreparedStatement sta = null;
        conn = getConnection();
        try {
            conn.setAutoCommit(false);//设置不自动提交
            sta = conn.prepareStatement(sql);
            if(obj != null){
                for(int i = 0; i < obj.length; i++){
                    sta.setObject(i+1,obj[i]);
                }
            }
            a = sta.executeUpdate();
            conn.commit();//提交数据
        } catch (SQLException e) {
            e.printStackTrace();
            /*回滚*/
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            close(null,sta,conn);
        }
        return a;
    }

    // 定义查询方法
    public static <T>List<T> executeQuery(String sql, RowMap<T> rm, Object... obj){
        List<T> lists= new ArrayList<>();
        Connection conn = null;
        PreparedStatement sta = null;
        conn = getConnection();
        try {
            sta = conn.prepareStatement(sql);
            if (obj != null){
                for (int i = 0 ;i < obj.length; i++){
                    sta.setObject(i+1,obj[i]);
                }
            }
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                T t = rm.RowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }
    /*查找一个*/
    public static <T> T queryOne(String sql, RowMap<T> rm, Object... obj){
        T t = null;
        Connection conn = null;
        PreparedStatement sta = null;
        conn = getConnection();
        try {
            sta = conn.prepareStatement(sql);
            if (obj != null){
                for (int i = 0 ;i < obj.length; i++){
                    sta.setObject(i+1,obj[i]);
                }
            }
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                t = rm.RowMapping(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    /*查数据条数*/
    public static <T> int executeCount(String sql,Object... obj){
        int a = 0;
        Connection conn = null;
        PreparedStatement sta = null;
        conn = getConnection();
        try {
            sta = conn.prepareStatement(sql);
            if (obj != null){
                for (int i = 0 ;i < obj.length; i++){
                    sta.setObject(i+1,obj[i]);
                }
            }
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                a = rs.getInt(1);  //循环第一列
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }



}
