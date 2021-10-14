package edu.neu.khoury.madsea.BingfanTian.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskRepository;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class Edit_Task extends AppCompatActivity {

    private static final String LOG_TAG =
            New_Task.class.getSimpleName();

    private Task newTask;
    private Task curTask;

    private String title;
    private int status;
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

    private TaskRepository mTaskRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSponner);
        mDdlDate = (EditText) findViewById(R.id.ddl_date);
        mIsRemind = findViewById(R.id.isRemind);
        mRemind_date = findViewById(R.id.remind_date);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.TEXT_SEND)){
            curTask = (Task) intent.getParcelableExtra(MainActivity.TEXT_SEND);
            setTaskProperties(curTask);
        }
    }

    public void editCurTask(View view) {

        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSponner);
        mDdlDate = (EditText) findViewById(R.id.ddl_date);
        mIsRemind = findViewById(R.id.isRemind);
        mRemind_date = findViewById(R.id.remind_date);

        mTaskRepository = new TaskRepository(this);

        if (!mTaskTitle.getText().toString().equals("")) {
            title = mTaskTitle.getText().toString();
            detail = mTaskDetail.getText().toString();
            tag = mTagSpinner.getSelectedItemPosition();
            deadLine = mDdlDate.getText().toString();
            isRemind = mIsRemind.isChecked();
            dateToRemind = null;

            int remindMark = 0;
            if (isRemind) {
                remindMark = 1;
                dateToRemind = mRemind_date.getText().toString();
            }
            newTask = new Task(title, status, detail, tag, deadLine, remindMark, dateToRemind);
            Log.d(LOG_TAG, newTask.toString());
            Log.d(LOG_TAG, "Edited Task save successful");
            Log.d(LOG_TAG, "-------");
            updateEditedTask();
            Log.d(LOG_TAG, "End EditTask");

            finish();
        }
    }

    private void setTaskProperties(Task curTask){
        mTaskTitle.setText(curTask.getTitle());
        mTaskDetail.setText(curTask.getDetail());
        mTagSpinner.setSelection(curTask.getTagPosition());
        mDdlDate.setText(curTask.getDeadLine());
        if (toBoolean(curTask.getIsRemind())) {
            mIsRemind.setChecked(true);
            mRemind_date.setText(curTask.getDateToRemind());
        } else {
            mIsRemind.setChecked(false);
        }
        status = curTask.getStatus();
    }

    public void cancelEdit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void updateEditedTask(){
        mTaskRepository.deleteTask(curTask);
        mTaskRepository.insertTask(newTask);
    }

    private String reformatInputDateString(String initial) {
        return initial.replaceAll("-", "/");
    }

    private String reformatOutputDateString(String initial) {
        return initial.replaceAll("/", "-");
    }

    private boolean toBoolean(int i){
        if (i == 1)
            return true;
        return false;
    }
}