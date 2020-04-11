package net.gxu.bsms.control.BookServlet;

import net.gxu.bsms.entity.Book;
import net.gxu.bsms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookAddServlet", urlPatterns = "/book/add")
public class BookAddServlet extends HttpServlet {
    BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int bookId = Integer.valueOf(request.getParameter("bookId"));
        String booKName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPublish = request.getParameter("bookPublish");
        float bookPrice = Float.valueOf(request.getParameter("bookPrice"));

        Book book = new Book(bookId, booKName, bookAuthor, bookPublish, bookPrice);
        int flag = bookService.addBook(book);
        if (flag == 0)
            out.print("0");
        else
            out.print("1");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
