package net.gxu.bsms.dao;

import net.gxu.bsms.entity.EntryRecord;
import net.gxu.bsms.entity.SalesRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesRecordMapper {

    List<SalesRecord> getSalesRecordInAllTime(@Param("bookId") int bookId, @Param("memberId") int memberId);
    List<SalesRecord> getSalesRecordInMouth(@Param("bookId") int bookId, @Param("memberId") int memberId);
    List<SalesRecord> getSalesRecordInWeek(@Param("bookId") int bookId, @Param("memberId") int memberId);
    List<SalesRecord> getSalesRecordInDay(@Param("bookId") int bookId, @Param("memberId") int memberId);

    int addSalesRecord(SalesRecord salesRecord);

    int deleteSalesRecordById(int salesRecordId);
}
