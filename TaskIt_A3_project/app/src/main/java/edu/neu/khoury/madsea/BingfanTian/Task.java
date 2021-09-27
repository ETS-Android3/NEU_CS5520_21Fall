package edu.neu.khoury.madsea.BingfanTian;

import java.util.Date;

public class Task {
    private String title;
    private String detail;
    private String tag;
    private Date deadLine;
    private boolean remind;
    private Date dateToRemind;

    public Task(String title, String detail, String tag, Date deadLine, boolean remind, Date dateToRemind) {
        this.title = title;
        this.detail = detail;
        this.tag = tag;
        this.deadLine = deadLine;
        this.remind = remind;
        this.dateToRemind = dateToRemind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public Date getDateToRemind() {
        return dateToRemind;
    }

    public void setDateToRemind(Date dateToRemind) {
        this.dateToRemind = dateToRemind;
    }
}
