package net.gxu.bsms.control.SystemServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.AllInfo;
import net.gxu.bsms.entity.NowInfo;
import net.gxu.bsms.service.InfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NowInfoServlet", urlPatterns = "/nowinfo")
public class NowInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();


        InfoService infoService= new InfoService();
        NowInfo nowInfo = infoService.getNowInfo();
        String allInfoJson = JSON.toJSONString(nowInfo);
        out.print(allInfoJson);
        out.close();
    }
}
