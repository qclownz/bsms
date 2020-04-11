package net.gxu.bsms.entity;

import java.util.Date;

/**
 *  实体类 书籍销售订单
 */
public class SalesRecord {
    private int id;
    private Date date;
    private int bookId;
    private int amount;
    private int memberId;
    private float price;
    private float value;

    public SalesRecord() {
    }

    public SalesRecord(int bookId, int amount, int memberId, float price, float value) {
        this.bookId = bookId;
        this.amount = amount;
        this.memberId = memberId;
        this.price = price;
        this.value = value;
    }


    public SalesRecord(int id, Date date, int bookId, int amount, int memberId, float price, float value) {
        this.id = id;
        this.date = date;
        this.bookId = bookId;
        this.amount = amount;
        this.memberId = memberId;
        this.price = price;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "id=" + id +
                ", date=" + date +
                ", bookId=" + bookId +
                ", amount=" + amount +
                ", memberId=" + memberId +
                ", price=" + price +
                ", value=" + value +
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
