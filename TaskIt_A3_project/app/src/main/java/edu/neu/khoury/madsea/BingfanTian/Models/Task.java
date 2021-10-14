package edu.neu.khoury.madsea.BingfanTian.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;

@Entity(tableName = "task_table")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

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


//    private final java.text.SimpleDateFormat formatter = new SimpleDateFormat( "MM-dd-yyyy");


    public Task(@NonNull String title, int status, String detail, int tagPosition, @NonNull String deadLine, int isRemind, String dateToRemind) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.tagPosition = tagPosition;
        this.deadLine = deadLine;
        this.isRemind = isRemind;
        this.dateToRemind = dateToRemind;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        title = in.readString();
        status = in.readInt();
        detail = in.readString();
        tagPosition = in.readInt();
        deadLine = in.readString();
        isRemind = in.readInt();
        dateToRemind = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public int getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(int remind) {
        this.isRemind = remind;
    }

    public String getDateToRemind() {
        return dateToRemind;
    }

    public void setDateToRemind(String dateToRemind) {
        this.dateToRemind = dateToRemind;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                ", tagPosition=" + tagPosition +
                ", deadLine='" + deadLine + '\'' +
                ", isRemind=" + isRemind +
                ", dateToRemind='" + dateToRemind + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeInt(status);
        parcel.writeString(detail);
        parcel.writeInt(tagPosition);
        parcel.writeString(deadLine);
        parcel.writeInt(isRemind);
        parcel.writeString(dateToRemind);
    }
}