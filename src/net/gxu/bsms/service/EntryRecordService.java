package net.gxu.bsms.service;

import net.gxu.bsms.dao.EntryRecordMapper;
import net.gxu.bsms.entity.EntryRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EntryRecordService {
    public List<EntryRecord> getAllEntryRecord(@Param("bookId")int bookId){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            return entryRecordMapper.getEntryRecordInAllTime(bookId);
        } finally {
            sqlSession.close();
        }
    }

    public  List<EntryRecord> getEntryRecordInMouth(@Param("bookId")int bookId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            return entryRecordMapper.getEntryRecordInMouth(bookId);
        } finally {
            sqlSession.close();
        }
    }

    public List<EntryRecord> getEntryRecordInWeek(@Param("bookId")int bookId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            return entryRecordMapper.getEntryRecordInWeek(bookId);
        } finally {
            sqlSession.close();
        }
    }

    public List<EntryRecord> getEntryRecordInDay(@Param("bookId")int bookId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            return entryRecordMapper.getEntryRecordInDay(bookId);
        } finally {
            sqlSession.close();
        }
    }

    public int addEntryRecord(EntryRecord entryRecord){
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            result = entryRecordMapper.addEntryRecord(entryRecord);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }

    public int deleteEntryRecordById(int entryRecordId) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            EntryRecordMapper entryRecordMapper = sqlSession.getMapper(EntryRecordMapper.class);
            result = entryRecordMapper.deleteEntryRecordById(entryRecordId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }
}
