package net.gxu.bsms.control.RecordServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.SalesRecord;
import net.gxu.bsms.service.SalesRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SalesRecordAddServlet", urlPatterns = "/sales/add")
public class SalesRecordAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        SalesRecordService salesRecordService = new SalesRecordService();
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        int amount = Integer.valueOf(request.getParameter("amount"));
        int memberId = Integer.valueOf(request.getParameter("memberId"));
        float price  = Float.valueOf(request.getParameter("price"));
        float value = Float.valueOf(request.getParameter("value"));
        SalesRecord salesRecord = new SalesRecord(bookId, amount, memberId, price, value);
        int flag = salesRecordService.addSalesRecord(salesRecord);
        out.print(JSON.toJSON(flag));
        out.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
    }
}
