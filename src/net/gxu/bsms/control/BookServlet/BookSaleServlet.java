package net.gxu.bsms.control.BookServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.Book;
import net.gxu.bsms.entity.Member;
import net.gxu.bsms.entity.SalesRecord;
import net.gxu.bsms.service.BookService;
import net.gxu.bsms.service.MemberService;
import net.gxu.bsms.service.SalesRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookSaleServlet", urlPatterns = "/book/sale")
public class BookSaleServlet extends HttpServlet {

    BookService bookService = new BookService();
    MemberService memberService = new MemberService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        int need = Integer.parseInt(request.getParameter("need"));
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        int amount = Integer.valueOf(request.getParameter("amount"));
        int flag = 0;
        Book book;
        Member member;
        SalesRecord salesRecord = null;
        book = bookService.getBookById(bookId);
        if (book != null && book.getAmount() >= amount) {

            Float price = book.getPrice() * amount;

            if (need == 0) {  // 非会员购买
                salesRecord = new SalesRecord(bookId, amount, -1, price, price);
                flag = 1;
            } else {  // 会员购买
                int memberId = Integer.parseInt(request.getParameter("memberId"));
                member = memberService.getMemberById(memberId);
                if (member == null) {
                    flag = -1;
                } else {
                    Float value = price * member.getDiscount();
                    salesRecord = new SalesRecord(bookId, amount, memberId, price, value);
                    flag = 1;
                }
            }
        }
        if (flag == 0 || flag == -1)
            out.print(JSON.toJSON(flag));
        else
            out.print(JSON.toJSON(salesRecord));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
    }
}
