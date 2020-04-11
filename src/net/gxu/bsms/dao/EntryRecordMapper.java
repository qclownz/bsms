package net.gxu.bsms.dao;

import net.gxu.bsms.entity.EntryRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntryRecordMapper {

    List<EntryRecord> getEntryRecordInAllTime(@Param("bookId") int bookId);
    List<EntryRecord> getEntryRecordInMouth(@Param("bookId")int bookId);
    List<EntryRecord> getEntryRecordInWeek(@Param("bookId")int bookId);
    List<EntryRecord> getEntryRecordInDay(@Param("bookId")int bookId);

    int addEntryRecord(EntryRecord entryRecord);
    int deleteEntryRecordById(int entryRecordId);

}
