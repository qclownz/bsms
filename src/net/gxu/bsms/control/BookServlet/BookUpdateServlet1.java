package net.gxu.bsms.control.BookServlet;

import net.gxu.bsms.entity.Book;
import net.gxu.bsms.entity.EntryRecord;
import net.gxu.bsms.service.BookService;
import net.gxu.bsms.service.EntryRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookUpdateServlet1", urlPatterns = "/book/add1")
public class BookUpdateServlet1 extends HttpServlet {
    BookService bookService = new BookService();
    EntryRecordService entryRecordService = new EntryRecordService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int bookId = Integer.valueOf(request.getParameter("bookId"));
        int amount = Integer.valueOf(request.getParameter("amount"));

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            out.print("0");
        } else {
            EntryRecord entryRecord = new EntryRecord(bookId, amount);
            int flag = entryRecordService.addEntryRecord(entryRecord);
            if (flag == 0)
                out.print("0");
            else
                out.print("1");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
