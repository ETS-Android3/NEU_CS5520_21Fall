package edu.neu.khoury.madsea.BingfanTian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class New_Task extends AppCompatActivity {

    private static final String LOG_TAG =
            New_Task.class.getSimpleName();
    public static final String EXTRA_REPLY =
            "newTask";

    private String title;
    private String detail;
    private int tag;
    private String deadLine;
    private boolean remind;
    private String dateToRemind;

    private EditText mTaskTitle;
    private EditText mTaskDetail;
    private Spinner mTagSpinner;
    private EditText mDdlDate;
    private CheckBox mIsRemind;
    private EditText mRemind_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_task);

    }

    public void createNewTask(View view) throws ParseException {
        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSponner);
        mDdlDate = (EditText) findViewById(R.id.ddl_date);
        mIsRemind = findViewById(R.id.isRemind);
        mRemind_date = findViewById(R.id.remind_date);

        if (mTaskTitle.getText() != null) {
            title = mTaskTitle.getText().toString();
            detail = mTaskDetail.getText().toString();
            tag = mTagSpinner.getSelectedItemPosition();
            deadLine = mDdlDate.getText().toString();
            remind = mIsRemind.isChecked();
            dateToRemind = mRemind_date.getText().toString();

            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "MM-dd-yyyy");
            Date deadLine_date =  formatter.parse(reformatDateString(deadLine));
            Date remind_date = null;
            if (remind)
                remind_date =  formatter.parse(reformatDateString(dateToRemind));

            Task newTask = new Task(1, 0, title, detail, tag, deadLine_date, remind, remind_date);

            Log.d(LOG_TAG, newTask.toString());

        Log.d(LOG_TAG, "New Task create successful");
        Log.d(LOG_TAG, "-------");

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, (Serializable) newTask);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "End Create new Task");
        finish();
        }
    }

    public void cancelCreate(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String reformatDateString(String initial){
        return initial.replaceAll("/", "-");
    }
}