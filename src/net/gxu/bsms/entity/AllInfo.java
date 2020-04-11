package net.gxu.bsms.entity;

public class AllInfo {
    private int bookKinds;
    private int bookAmounts;
    private float bookValues;
    private int memberAmounts;
    private int saleAmounts;
    private float saleValues;

    public AllInfo() {
    }

    public AllInfo(int bookKinds, int bookAmounts, float bookValues, int memberAmounts, int saleAmounts, float saleValues) {
        this.bookKinds = bookKinds;
        this.bookAmounts = bookAmounts;
        this.bookValues = bookValues;
        this.memberAmounts = memberAmounts;
        this.saleAmounts = saleAmounts;
        this.saleValues = saleValues;
    }


    @Override
    public String toString() {
        return "AllInfo{" +
                "bookKinds=" + bookKinds +
                ", bookAmounts=" + bookAmounts +
                ", bookValues=" + bookValues +
                ", memberAmounts=" + memberAmounts +
                ", saleAmounts=" + saleAmounts +
                ", saleValues=" + saleValues +
                '}';
    }

    public int getBookKinds() {
        return bookKinds;
    }

    public void setBookKinds(int bookKinds) {
        this.bookKinds = bookKinds;
    }

    public int getBookAmounts() {
        return bookAmounts;
    }

    public void setBookAmounts(int bookAmounts) {
        this.bookAmounts = bookAmounts;
    }

    public float getBookValues() {
        return bookValues;
    }

    public void setBookValues(float bookValues) {
        this.bookValues = bookValues;
    }

    public int getMemberAmounts() {
        return memberAmounts;
    }

    public void setMemberAmounts(int memberAmounts) {
        this.memberAmounts = memberAmounts;
    }

    public int getSaleAmounts() {
        return saleAmounts;
    }

    public void setSaleAmounts(int saleAmounts) {
        this.saleAmounts = saleAmounts;
    }

    public float getSaleValues() {
        return saleValues;
    }

    public void setSaleValues(float saleValues) {
        this.saleValues = saleValues;
    }
}
