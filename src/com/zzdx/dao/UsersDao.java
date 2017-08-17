package com.zzdx.dao;

import com.zzdx.bean.Users;
import com.zzdx.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by tong- on 2017/5/1.
 */
public class UsersDao {
    //查询用户名重复
    public boolean selectUserName(String userName){
        String sql = "select * from users where userName = '"+userName+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        boolean b = false;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    b = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return b;
    }

    //用户登录
    public Users loginUser(String userName, String userPassword){
        String sql = "select * from users where userName = '"+userName+"' and userPassword = '"+userPassword+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        Users user =new Users();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    user.setUserId(rs.getInt("userId"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setUserType(rs.getInt("userType"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return user;
    }

    //用户注册
    public int registUser(String userName, String userPassword){
        String sql = "insert into users(userName,userPassword) values('"+userName+"','"+userPassword+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改密码
    public int updateUserPassword(int userId,String userPassword){
        String sql = "update users set userPassword = '"+userPassword+"' where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }
}
