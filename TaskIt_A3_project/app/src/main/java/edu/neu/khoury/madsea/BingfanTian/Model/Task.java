package edu.neu.khoury.madsea.BingfanTian.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {

    private int id;
    private int status;

    private String title;
    private String detail;
    private int tagPosition;
    private Date deadLine;
    private boolean remind;
    private Date dateToRemind;
    private final java.text.SimpleDateFormat formatter = new SimpleDateFormat( "MM-dd-yyyy");

    public Task(int id, int status, String title, String detail, int tagPosition, Date deadLine, boolean remind, Date dateToRemind) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.tagPosition = tagPosition;
        this.deadLine = deadLine;
        this.remind = remind;
        this.dateToRemind = dateToRemind;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getTagPosition() {
        return tagPosition;
    }

    public void setTagPosition(int tagPosition) {
        this.tagPosition = tagPosition;
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

    public SimpleDateFormat getFormatter() {
        return formatter;
    }
}
