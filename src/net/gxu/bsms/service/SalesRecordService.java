package net.gxu.bsms.service;

import net.gxu.bsms.dao.EntryRecordMapper;
import net.gxu.bsms.dao.SalesRecordMapper;
import net.gxu.bsms.entity.SalesRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SalesRecordService {


    public List<SalesRecord> getSalesRecordInAllTime(@Param("bookId") int bookId, @Param("memberId") int memberId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            return salesRecordMapper.getSalesRecordInAllTime(bookId, memberId);
        } finally {
            sqlSession.close();
        }
    }
    public List<SalesRecord> getSalesRecordInMouth(@Param("bookId") int bookId, @Param("memberId") int memberId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            return salesRecordMapper.getSalesRecordInMouth(bookId, memberId);
        } finally {
            sqlSession.close();
        }
    }
    public List<SalesRecord> getSalesRecordInWeek(@Param("bookId") int bookId, @Param("memberId") int memberId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            return salesRecordMapper.getSalesRecordInWeek(bookId, memberId);
        } finally {
            sqlSession.close();
        }
    }
    public List<SalesRecord> getSalesRecordInDay(@Param("bookId") int bookId, @Param("memberId") int memberId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            return salesRecordMapper.getSalesRecordInDay(bookId, memberId);
        } finally {
            sqlSession.close();
        }
    }

    public int addSalesRecord(SalesRecord salesRecord){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            result = salesRecordMapper.addSalesRecord(salesRecord);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    };

    public int deleteSalesRecordById(int salesrecordId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            SalesRecordMapper salesRecordMapper = sqlSession.getMapper(SalesRecordMapper.class);
            result = salesRecordMapper.deleteSalesRecordById(salesrecordId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }

}
