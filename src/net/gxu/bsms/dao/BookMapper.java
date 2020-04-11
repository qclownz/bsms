package net.gxu.bsms.dao;

import net.gxu.bsms.entity.Book;

import java.util.List;

public interface BookMapper {

    Book getBookById(int id);
    List<Book> getBooksByName(String name);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByAmount(int amount);
    List<Book> getAllBooks();

    int addBook(Book book);

    int updateBookById(Book book);
    int updateBookAmountById(Book book);

    int deleteBookById(int id);

}
