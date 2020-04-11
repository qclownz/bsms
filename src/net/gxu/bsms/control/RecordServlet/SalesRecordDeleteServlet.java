package net.gxu.bsms.control.RecordServlet;

import net.gxu.bsms.service.SalesRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SalesRecordDeleteServlet", urlPatterns = "/salesrecord/delete")
public class SalesRecordDeleteServlet extends HttpServlet {

    SalesRecordService salesRecordService = new SalesRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int salesRecordId = Integer.parseInt(request.getParameter("salesRecordId"));

        int flag = salesRecordService.deleteSalesRecordById(salesRecordId);
        if (flag == 0)
            out.print("0");
        else
            out.print("1");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
    }
}
