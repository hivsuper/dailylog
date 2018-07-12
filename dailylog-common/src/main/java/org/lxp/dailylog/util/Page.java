package org.lxp.dailylog.util;

import java.util.List;

public class Page<T> {
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_START = "0";

    private String draw;
    private int start = Integer.valueOf(DEFAULT_START);
    private int recordsTotal;
    private int recordsFiltered;

    private List<T> data;

    public Page(String draw, int start) {
        this.start = start;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
