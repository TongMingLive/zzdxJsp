package com.zzdx.dao;

import com.zzdx.bean.Studyclass;
import com.zzdx.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong- on 2017/5/1.
 */
public class StudyclassDao {

    //查看个人课程表
    public List<Studyclass> selectClassByUser(int userId){
        String sql = "SELECT * FROM studyclass WHERE userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Studyclass> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Studyclass studyclass = new Studyclass();
                    studyclass.setClassId(rs.getInt("classId"));
                    studyclass.setClassName(rs.getString("className"));
                    studyclass.setClassTime(rs.getString("classTime"));
                    studyclass.setUserId(rs.getInt("userId"));
                    list.add(studyclass);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //添加课程表
    public int addClassByUser(int Id,String Name,String Time){
        String sql = "insert into studyclass(userId,className,classTime) values("+Id+",'"+Name+"','"+Time+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除课程表
    public int deleteClassById(int classId){
        String sql = "delete from studyclass where classId = "+classId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改课程
    public int updateClassById(int Id,String Name,String Time){
        String sql = "update studyclass set className = '"+Name+"',classTime = '"+Time+"' where classId = "+Id;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
