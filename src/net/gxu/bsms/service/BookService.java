package net.gxu.bsms.service;

import net.gxu.bsms.dao.BookMapper;
import net.gxu.bsms.entity.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookService {

    public Book getBookById (int id) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBookById(id);

        } finally {
            sqlSession.close();
        }
    }

    public List<Book> getBooksByName (String name) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBooksByName(name);

        } finally {
            sqlSession.close();
        }
    }

    public List<Book> getBooksByAuthor (String author) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBooksByAuthor(author);

        } finally {
            sqlSession.close();
        }
    }

    public List<Book> getBooksAmount(int amount) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getBooksByAmount(amount);

        } finally {
            sqlSession.close();
        }
    }

    public List<Book> getAllBooks () {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            return bookMapper.getAllBooks();

        } finally {
            sqlSession.close();
        }
    }

    public int addBook(Book book){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            BookMapper memberMapper = sqlSession.getMapper(BookMapper.class);
            result = memberMapper.addBook(book);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    };

    public int updateBookAmountById(Book book) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            BookMapper memberMapper = sqlSession.getMapper(BookMapper.class);
            result = memberMapper.updateBookAmountById(book);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }
    public int updateBookById(Book book){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            BookMapper memberMapper = sqlSession.getMapper(BookMapper.class);
            result = memberMapper.updateBookById(book);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    };

    public int deleteBookById(int id){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            BookMapper memberMapper = sqlSession.getMapper(BookMapper.class);
            result = memberMapper.deleteBookById(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    };
}
