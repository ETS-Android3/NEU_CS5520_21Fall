package edu.neu.khoury.madsea.BingfanTian.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.neu.khoury.madsea.BingfanTian.Database.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class Edit_Task extends AppCompatActivity {

    private static final String LOG_TAG =
            New_Task.class.getSimpleName();

    public static final String EXTRA_REPLY =
            "editedTask";
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
        setContentView(R.layout.activity_edit_task);

        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSponner);
        mDdlDate = (EditText) findViewById(R.id.ddl_date);
        mIsRemind = findViewById(R.id.isRemind);
        mRemind_date = findViewById(R.id.remind_date);

        Intent intent = getIntent();
        Task curTask = (Task) intent.getSerializableExtra(MainActivity.TEXT_SEND);
        mTaskTitle.setText(curTask.getTitle());
        mTaskDetail.setText(curTask.getDetail());
        mTagSpinner.setSelection(curTask.getTagPosition());
        java.text.SimpleDateFormat input_formatter = new SimpleDateFormat( "MM-dd-yyyy");
        mDdlDate.setText(reformatInputDateString(input_formatter.format(curTask.getDeadLine())));
        if (curTask.getIsRemind() == 1){
            mIsRemind.setSelected(true);
            mRemind_date.setText(reformatInputDateString(input_formatter.format(curTask.getDateToRemind())));
        } else {
            mIsRemind.setSelected(false);
        }

    }

    public void editCurTask(View view) throws ParseException {
//        if (mTaskTitle.getText() != null) {
//            title = mTaskTitle.getText().toString();
//            detail = mTaskDetail.getText().toString();
//            tag = mTagSpinner.getSelectedItemPosition();
//            deadLine = mDdlDate.getText().toString();
//            remind = mIsRemind.isChecked();
//            dateToRemind = mRemind_date.getText().toString();
//
//            java.text.SimpleDateFormat output_formatter = new SimpleDateFormat( "MM-dd-yyyy");
//            Date deadLine_date =  output_formatter.parse(reformatOutputDateString(deadLine));
//            Date remind_date = null;
//            if (remind)
//                remind_date =  output_formatter.parse(reformatOutputDateString(dateToRemind));
//
//            Task newTask = new Task(title, detail, tag, deadLine_date, remind, remind_date);
//
//            Log.d(LOG_TAG, newTask.toString());
//
//            Log.d(LOG_TAG, "New Task create successful");
//            Log.d(LOG_TAG, "-------");
//
//            Intent replyIntent = new Intent();
//            replyIntent.putExtra(EXTRA_REPLY, newTask);
//            setResult(RESULT_OK, replyIntent);
//            Log.d(LOG_TAG, "End Create new Task");
//            finish();
//        }
    }

    public void cancelEdit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String reformatInputDateString(String initial){
        return initial.replaceAll("-", "/");
    }
    private String reformatOutputDateString(String initial){
        return initial.replaceAll("/", "-");
    }
}