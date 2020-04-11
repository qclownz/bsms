package net.gxu.bsms.control.RecordServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.EntryRecord;
import net.gxu.bsms.service.EntryRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EntryRecordSelectServlet", urlPatterns = "/entryrecord/select")
public class EntryRecordSelectServlet extends HttpServlet {

    EntryRecordService entryRecordService = new EntryRecordService();
    String entryRecordJson;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int bookId = -1;
        String need = request.getParameter("need");
        String bookIdStr = request.getParameter("bookId");
        if(!bookIdStr.equals(""))
            bookId = Integer.parseInt(bookIdStr);
        List<EntryRecord> entryRecordList = new ArrayList<>();
        switch (need) {
            case "0":
                entryRecordList = entryRecordService.getAllEntryRecord(bookId);
                break;
            case "1":
                entryRecordList = entryRecordService.getEntryRecordInMouth(bookId);
                break;
            case "2":
                entryRecordList = entryRecordService.getEntryRecordInWeek(bookId);
                break;
            case "3":
                entryRecordList = entryRecordService.getEntryRecordInDay(bookId);
                break;
        }
        entryRecordJson = JSON.toJSONString(entryRecordList);
        out.print(entryRecordJson);
        out.close();
    }
}
