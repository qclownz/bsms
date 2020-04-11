package net.gxu.bsms.entity;

import java.util.Date;

/**
 *  实体类 书籍入库订单
 */
public class EntryRecord {
    private int id;
    private Date date;
    private int bookId;
    private int amount;

    public EntryRecord() {
    }

    public EntryRecord(int bookId, int amount) {
        this.bookId = bookId;
        this.amount = amount;
    }

    public EntryRecord(int id, Date date, int bookId, int amount) {
        this.id = id;
        this.date = date;
        this.bookId = bookId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EntryRecord{" +
                "id=" + id +
                ", date=" + date +
                ", bookId=" + bookId +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
