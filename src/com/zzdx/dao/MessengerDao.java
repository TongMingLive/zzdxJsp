package com.zzdx.dao;

import com.zzdx.bean.Messenger;
import com.zzdx.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tong- on 2017/5/1.
 */
public class MessengerDao {

    //查询全部留言
    public List<Messenger> selectAllMessenger(){
        String sql = "SELECT m.*,u.userName FROM messenger m,users u WHERE m.userId = u.userId";
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Messenger> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Messenger messenger = new Messenger();
                    messenger.setMessengerId(rs.getInt("messengerId"));
                    messenger.setMessengerTitle(rs.getString("messengerTitle"));
                    messenger.setMessengerPage(rs.getString("messengerPage"));
                    messenger.setUserId(rs.getInt("userId"));
                    messenger.setUserName(rs.getString("userName"));
                    list.add(messenger);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //添加留言
    public int addMessenger(String messengerTitle,String messengerPage,int userId){
        String sql = "insert into messenger(messengerTitle,messengerPage,userId) values('"+messengerTitle+"','"+messengerPage+"',"+userId+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
