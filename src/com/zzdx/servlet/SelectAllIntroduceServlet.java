package com.zzdx.servlet;

import com.zzdx.bean.Introduce;
import com.zzdx.bean.Messenger;
import com.zzdx.dao.IntroduceDao;
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
@WebServlet(name = "SelectAllIntroduceServlet",urlPatterns = "/SelectAllIntroduceServlet")
public class SelectAllIntroduceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        IntroduceDao dao = new IntroduceDao();
        List<Introduce> introduces = dao.selectAllIntroduce();

        JSONArray jsonArray = JSONArray.fromObject(introduces);
        out.print(jsonArray.toString());

        out.flush();
        out.close();

    }
}
