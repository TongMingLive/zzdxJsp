package com.zzdx.dao;

import com.zzdx.bean.Introduce;
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
public class IntroduceDao {

    //查询全部介绍
    public List<Introduce> selectAllIntroduce(){
        String sql = "SELECT i.*,t.* FROM introduce i,type t WHERE i.typeId = t.typeId";
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Introduce> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Introduce introduce = new Introduce();
                    introduce.setIntroduceId(rs.getInt("introduceId"));
                    introduce.setTypeId(rs.getInt("typeId"));
                    introduce.setTypeName(rs.getString("typeName"));
                    introduce.setTypeColor(rs.getString("typeColor"));
                    introduce.setIntroducePage(rs.getString("introducePage"));
                    introduce.setIntroduceAddress(rs.getString("introduceAddress"));
                    introduce.setIntroduceGps(rs.getString("introduceGps"));
                    introduce.setIntroduceName(rs.getString("introduceName"));
                    list.add(introduce);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

}
