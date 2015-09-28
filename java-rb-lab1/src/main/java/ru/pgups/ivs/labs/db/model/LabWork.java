package ru.pgups.ivs.labs.db.model;

import java.math.BigDecimal;

public class LabWork {
    private long id;
    private int courseIdx;
    private String title;
    private String text;
    private BigDecimal maxCredits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCourseIdx() {
        return courseIdx;
    }

    public void setCourseIdx(int courseIdx) {
        this.courseIdx = courseIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getMaxCredits() {
        return maxCredits;
    }

    public void setMaxCredits(BigDecimal maxCredits) {
        this.maxCredits = maxCredits;
    }
}
