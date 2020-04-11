package net.gxu.bsms.entity;

public class NowInfo {
    private int todayAmounts;
    private float todayValues;
    private int thisMonthAmounts;
    private float thisMonthValues;

    public NowInfo() {
    }

    public NowInfo(int todayAmounts, float todayValues, int thisMonthAmounts, float thisMonthValues) {
        this.todayAmounts = todayAmounts;
        this.todayValues = todayValues;
        this.thisMonthAmounts = thisMonthAmounts;
        this.thisMonthValues = thisMonthValues;
    }

    @Override
    public String toString() {
        return "NowInfo{" +
                "todayAmounts=" + todayAmounts +
                ", todayValues=" + todayValues +
                ", thisMonthAmounts=" + thisMonthAmounts +
                ", thisMonthValues=" + thisMonthValues +
                '}';
    }


    public int getTodayAmounts() {
        return todayAmounts;
    }

    public void setTodayAmounts(int todayAmounts) {
        this.todayAmounts = todayAmounts;
    }

    public float getTodayValues() {
        return todayValues;
    }

    public void setTodayValues(float todayValues) {
        this.todayValues = todayValues;
    }

    public int getThisMonthAmounts() {
        return thisMonthAmounts;
    }

    public void setThisMonthAmounts(int thisMonthAmounts) {
        this.thisMonthAmounts = thisMonthAmounts;
    }

    public float getThisMonthValues() {
        return thisMonthValues;
    }

    public void setThisMonthValues(float thisMonthValues) {
        this.thisMonthValues = thisMonthValues;
    }
}
