package net.gxu.bsms.control.RecordServlet;

import net.gxu.bsms.service.EntryRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EntryRecordDeleteServlet", urlPatterns = "/entryrecord/delete")
public class EntryRecordDeleteServlet extends HttpServlet {

    EntryRecordService entryRecordService = new EntryRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int entryRecordId = Integer.parseInt(request.getParameter("entryRecordId"));

        int flag = entryRecordService.deleteEntryRecordById(entryRecordId);
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
