package edu.neu.khoury.madsea.BingfanTian.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskRepository;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class Task_Detail extends AppCompatActivity {

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
    private int edit_index;

    private TextView mTaskTitle;
    private TextView mTaskDetail;
    private Spinner mTagSpinner;
    private TextView mDdlDate;
    private CheckBox mIsRemind;
    private TextView mRemind_date;

    private TaskRepository mTaskRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSpinner);
        mDdlDate = findViewById(R.id.ddl_date);
        mIsRemind = findViewById(R.id.isRemind);
        mRemind_date = findViewById(R.id.remind_date);

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.TEXT_SEND)){
            curTask = (Task) intent.getParcelableExtra(MainActivity.TEXT_SEND);
            setTaskProperties(curTask);
        }
    }

    public void cancelEdit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
        edit_index = curTask.getId();
    }

    private boolean toBoolean(int i){
        if (i == 1)
            return true;
        return false;
    }
}