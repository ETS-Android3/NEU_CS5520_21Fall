package edu.neu.khoury.madsea.BingfanTian.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "task_table")
public class Task implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "detail")
    private String detail;

    @NonNull
    @ColumnInfo(name = "tagPosition")
    private int tagPosition;

    @NonNull
    @ColumnInfo(name = "deadLine")
    private String deadLine;

    @ColumnInfo(name = "isRemind")
    private int isRemind;

    @ColumnInfo(name = "dateToRemind")
    private String dateToRemind;

    public Task(@NonNull String title, int status, String detail, int tagPosition, @NonNull String deadLine, int isRemind, String dateToRemind) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.tagPosition = tagPosition;
        this.deadLine = deadLine;
        this.isRemind = isRemind;
        this.dateToRemind = dateToRemind;
    }

    public int getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public int getTagPosition() {
        return tagPosition;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public int getIsRemind() {
        return isRemind;
    }

    public String getDateToRemind() {
        return dateToRemind;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setTagPosition(int tagPosition) {
        this.tagPosition = tagPosition;
    }

    public void setDeadLine(@NonNull String deadLine) {
        this.deadLine = deadLine;
    }

    public void setIsRemind(int isRemind) {
        this.isRemind = isRemind;
    }

    public void setDateToRemind(String dateToRemind) {
        this.dateToRemind = dateToRemind;
    }
}
