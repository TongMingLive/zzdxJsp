package com.zzdx.servlet;

import com.zzdx.dao.MessengerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong- on 2017/5/4.
 */
@WebServlet(name = "AddMessengerServlet",urlPatterns = "/AddMessengerServlet")
public class AddMessengerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String messengerTitle = request.getParameter("messengerTitle");
        String messengerPage = request.getParameter("messengerPage");
        int userId = Integer.parseInt(request.getParameter("userId"));

        MessengerDao dao = new MessengerDao();
        int r = dao.addMessenger(messengerTitle,messengerPage,userId);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }

        out.flush();
        out.close();
    }
}
