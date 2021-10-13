package edu.neu.khoury.madsea.BingfanTian.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

import edu.neu.khoury.madsea.BingfanTian.Model.Task;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "ToDoDatabase";
    private static final String TODO_TABLE = "todo";
    private static final String ID = "id";
    private static final String STATUS = "status";
    private static final String TITLE = "title";
    private static final String DETAIL = "detail";
    private static final String TAG = "tagPosition";
    private static final String ISREMIND = "isRemind";
    private static final String DDL = "deadLine";
    private static final String DATETOREMIND = "dateToRemind";
    /*
    CREATE TABLE ToDoDatabase(
        id              INTEGER PRIMARY KEY AUTOINCREMENT,
        title           STRING,
        status          INTEGER,
        detail          TEXT,
        tagPosition     INTEGER,
        deadLine        STRING,
        isRemind        INTEGER,
        dateToRemind    STRING
        )
 */
    private static final String CREATE_TODO_TABLE =
            "CREATE TABLE " + TODO_TABLE + "(" +
                    ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TITLE + "STRING, " +
                    STATUS + "INTEGER, " +
                    DETAIL + "TEXT, " +
                    TAG + "INTEGER, " +
                    DDL + "STRING, " +
                    ISREMIND + "INTEGER, " +
                    TAG + "INTEGER, " +
                    DATETOREMIND + "STRING" +
                    ")";
    private java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");


    private SQLiteDatabase db;

    private DatabaseHandler(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the older tables
        db.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void openDatabase() {
        db = this.getWritableDatabase();
    }

    public void insertTask(Task task) {
        ContentValues cv = new ContentValues();
        cv.put(TITLE, task.getTitle());
        cv.put(STATUS, task.getStatus());
        cv.put(DETAIL, task.getDetail());
        cv.put(TAG, task.getTagPosition());
        cv.put(DDL, reformatInputDateString(formatter.format(task.getDeadLine())));
        cv.put(ISREMIND, task.isRemind());
        cv.put(DATETOREMIND, reformatInputDateString(formatter.format(task.getDateToRemind())));
        db.insert(TODO_TABLE, null, cv);
    }

    public List<Task> getAllTask() throws ParseException {
        List<Task> newList = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try {
            cur = db.query(TODO_TABLE, null, null, null, null, null, null, null);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    do {
                        int status = cur.getInt(cur.getColumnIndex(STATUS));
                        String title = cur.getString(cur.getColumnIndex(TITLE));
                        String detail = cur.getString(cur.getColumnIndex(DETAIL));
                        int tagPosition = cur.getInt(cur.getColumnIndex(TAG));
                        Date deadLine = formatter.parse(cur.getString(cur.getColumnIndex(DDL)));
                        int isRemind = cur.getInt(cur.getColumnIndex(ISREMIND));
                        Task newTask;
                        if (isRemind != 0) {
                            newTask = new Task(status, title, detail, tagPosition, deadLine, isRemind, null);
                        } else {
                            Date dateToRemind = formatter.parse(cur.getString(cur.getColumnIndex(DATETOREMIND)));
                            newTask = new Task(status, title, detail, tagPosition, deadLine, isRemind, dateToRemind);
                        }
                        newList.add(newTask);
                    } while (cur.moveToNext());
                }
            }
        } finally {
            db.endTransaction();
            cur.close();
        }
        return newList;
    }

    public void updateStatus(int id, int status){
        ContentValues cv = new ContentValues();
        cv.put(STATUS, status);
        db.update(TODO_TABLE, cv, ID + "=?", new String[] {String.valueOf(id)});
    }

    public void updateTask(int id, Task task){
        ContentValues cv = new ContentValues();
        cv.put(TITLE, task.getTitle());
        cv.put(STATUS, task.getStatus());
        cv.put(DETAIL, task.getDetail());
        cv.put(TAG, task.getTagPosition());
        cv.put(DDL, reformatInputDateString(formatter.format(task.getDeadLine())));
        cv.put(ISREMIND, task.isRemind());
        cv.put(DATETOREMIND, reformatInputDateString(formatter.format(task.getDateToRemind())));
        db.update(TODO_TABLE, cv, ID + " +?", new String[]{String.valueOf(id)});
    }

    public void deleteTask(int id){
        db.delete(TODO_TABLE, ID + " +?", new String[]{String.valueOf(id)});
    }

    private String reformatInputDateString(String initial) {
        return initial.replaceAll("-", "/");
    }
}
