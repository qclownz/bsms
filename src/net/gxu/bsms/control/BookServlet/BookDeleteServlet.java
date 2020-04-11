package net.gxu.bsms.control.BookServlet;

import net.gxu.bsms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookDeleteServlet", urlPatterns = "/book/delete")
public class BookDeleteServlet extends HttpServlet {
    BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        int flag = bookService.deleteBookById(bookId);
        if (flag == 0)
            out.print("0");
        else
            out.print("1");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
