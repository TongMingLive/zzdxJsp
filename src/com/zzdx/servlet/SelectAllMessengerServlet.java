package com.zzdx.servlet;

import com.zzdx.bean.Messenger;
import com.zzdx.dao.MessengerDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong- on 2017/5/1.
 */
@WebServlet(name = "SelectAllMessengerServlet",urlPatterns = "/SelectAllMessengerServlet")
public class SelectAllMessengerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        MessengerDao dao = new MessengerDao();
        List<Messenger> messenger = dao.selectAllMessenger();

        JSONArray jsonArray = JSONArray.fromObject(messenger);
        out.print(jsonArray.toString());

        out.flush();
        out.close();

    }
}
