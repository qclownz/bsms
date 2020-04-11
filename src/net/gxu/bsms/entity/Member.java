package net.gxu.bsms.entity;

import java.util.Date;

/**
 *  实体类 会员
 */
public class Member {

    private int id;
    private float discount;
    private String name;
    private String tel;
    private Date date;

    public Member() {

    }

    public Member(float discount, String name, String tel) {
        this.discount = discount;
        this.name = name;
        this.tel = tel;
    }

    public Member(int id, float discount, String name, String tel) {
        this.id = id;
        this.discount = discount;
        this.name = name;
        this.tel = tel;
    }

    public Member(int id, float discount, String name, String tel, Date date) {
        this.id = id;
        this.discount = discount;
        this.name = name;
        this.tel = tel;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", discount=" + discount +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}





