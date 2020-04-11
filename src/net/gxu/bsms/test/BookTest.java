package net.gxu.bsms.test;

import net.gxu.bsms.entity.Book;
import net.gxu.bsms.service.BookService;

import java.util.List;

public class BookTest {
    public static void printBooks(List<Book> bookList) {
        for(Book book :bookList){
            System.out.println(book);
        }

    }
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Book book;
        List<Book> bookList;
/***
 *
 ***/
//        book = bookService.getBookById(99999);
//        System.out.println(book);
//        bookList = bookService.getBooksByAuthor("李白");
//        printBooks(bookList);
//        bookList = bookService.getBooksByName("入门到精通");
//        printBooks(bookList);
        book = new Book(22356, "Python不香吗", "李彩", "广西大学出版社", 9.9f, 10);
        int i = bookService.addBook(book);
//        int i = bookService.updateBookAmountById(book);
//        int i = bookService.updateBookById(book);
//        int i = bookService.deleteBookById(12345);
        System.out.println(i);
//        bookList = bookService.getAllBooks();
//        printBooks(bookList);
    }
}
