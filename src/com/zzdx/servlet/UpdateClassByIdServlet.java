package com.zzdx.servlet;

import com.zzdx.dao.StudyclassDao;

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
@WebServlet(name = "UpdateClassByIdServlet",urlPatterns = "/UpdateClassByIdServlet")
public class UpdateClassByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int Id = Integer.parseInt(request.getParameter("classId"));
        String Name = request.getParameter("className");
        String Time = request.getParameter("classTime");

        StudyclassDao dao = new StudyclassDao();
        int r = dao.updateClassById(Id,Name,Time);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
