package edu.neu.khoury.madsea.BingfanTian.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.neu.khoury.madsea.BingfanTian.Database.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class New_Task extends AppCompatActivity {

    private static final String LOG_TAG =
            New_Task.class.getSimpleName();
    public static final String EXTRA_REPLY =
            "newTask";

    private String title;
    private String detail;
    private int tag;
    private String deadLine;
    private boolean isRemind;
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

        if (!mTaskTitle.getText().toString().equals("")) {
            title = mTaskTitle.getText().toString();
            detail = mTaskDetail.getText().toString();
            tag = mTagSpinner.getSelectedItemPosition();
            deadLine = mDdlDate.getText().toString();
            isRemind = mIsRemind.isChecked();
            dateToRemind = mRemind_date.getText().toString();

            java.text.SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
//            Date deadLine_date = formatter.parse(reformatDateString(deadLine));
//            Date remind_date = null;
            int remindMark = 0;
            if (isRemind) {
//                remind_date = formatter.parse(reformatDateString(dateToRemind));
                remindMark = 1;
            }

            Task newTask = new Task(title, 0, detail, tag, deadLine, remindMark, dateToRemind);
//            db = new DatabaseHandler(getActivity());
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

    private String reformatDateString(String initial) {
        return initial.replaceAll("/", "-");
    }
}