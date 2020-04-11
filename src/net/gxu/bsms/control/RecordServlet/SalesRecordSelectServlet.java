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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SalesRecordSelectServlet", urlPatterns = "/salesrecord/select")
public class SalesRecordSelectServlet extends HttpServlet {

    SalesRecordService salesRecordService = new SalesRecordService();
    String salesRecordJson;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        int bookId = -1, memberId = -1;

        String need = request.getParameter("need");
        String bookIdStr = request.getParameter("bookId");
        String memberIdStr = request.getParameter("memberId");
        if (!bookIdStr.equals("")) {
            bookId = Integer.parseInt(bookIdStr);
        }
        if (!memberIdStr.equals("")) {
            memberId = Integer.parseInt(memberIdStr);
        }

        List<SalesRecord> salesRecordList = new ArrayList<>();
        switch (need) {
            case "0":
                salesRecordList = salesRecordService.getSalesRecordInAllTime(bookId, memberId);
                break;
            case "1":
                salesRecordList = salesRecordService.getSalesRecordInMouth(bookId, memberId);
                break;
            case "2":
                salesRecordList = salesRecordService.getSalesRecordInWeek(bookId, memberId);
                break;
            case "3":
                salesRecordList = salesRecordService.getSalesRecordInDay(bookId, memberId);
                break;
        }
        salesRecordJson = JSON.toJSONString(salesRecordList);
        out.print(salesRecordJson);
        out.close();

    }
}
