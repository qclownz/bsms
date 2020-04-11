package net.gxu.bsms.control.BookServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.Book;
import net.gxu.bsms.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "BookSelectServlet", urlPatterns = "/book/select")
public class BookSelectServlet extends HttpServlet {
    BookService bookService = new BookService();
    String bookJson = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        String need = request.getParameter("need");

        Book book;
        List<Book> bookList = new ArrayList<>();
        switch (need) {
            case "0":
                int bookId = Integer.valueOf(request.getParameter("bookSelectInfo"));
                book = bookService.getBookById(bookId);
                if(book == null)
                    break;
                bookList.add(book);
                break;
            case "1":
                String bookName = request.getParameter("bookSelectInfo");
                bookList = bookService.getBooksByName(bookName);
                break;
            case "2":
                String bookAuthor = request.getParameter("bookSelectInfo");
                bookList = bookService.getBooksByAuthor(bookAuthor);
                break;
            case "3":
                int amount = Integer.parseInt(request.getParameter("bookSelectInfo"));
                bookList = bookService.getBooksAmount(amount);
                break;
            case "4":
                bookList = bookService.getAllBooks();
                break;
        }
        bookJson = JSON.toJSONString(bookList);
        out.print(bookJson);
        out.close();
    }
}
