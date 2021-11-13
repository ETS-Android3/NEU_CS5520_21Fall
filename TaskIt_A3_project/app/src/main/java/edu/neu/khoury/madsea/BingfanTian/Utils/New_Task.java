package edu.neu.khoury.madsea.BingfanTian.Utils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskRepository;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskViewModel;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class New_Task extends AppCompatActivity {

    /**
     * notification pops up 6 hours before due
     */
    private static final long SIX_HOURS = 1440000;

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
    private int status;

    private Task newTask;

    private EditText mTaskTitle;
    private EditText mTaskDetail;
    private Spinner mTagSpinner;
    private EditText mDdlDate;
    private CheckBox mIsRemind;
    private EditText mRemind_date;

    private TaskRepository mTaskRepository;
    private TaskViewModel mTaskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mDdlDate = findViewById(R.id.ddl_date);
        mDdlDate.setInputType(InputType.TYPE_NULL);
        mDdlDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(mDdlDate);
            }
        });

        mRemind_date = findViewById(R.id.remind_date);
        mRemind_date.setInputType(InputType.TYPE_NULL);
        mRemind_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(mRemind_date);
            }
        });
        mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
    }

    private void showDateDialog(EditText mDdlDate) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

                        mDdlDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(
                        New_Task.this,
                        timeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        false).show();
            }
        };

        new DatePickerDialog(
                New_Task.this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    public void createNewTask(View view) throws ParseException {
        mTaskTitle = findViewById(R.id.task_title);
        mTaskDetail = findViewById(R.id.task_detail);
        mTagSpinner = findViewById(R.id.tagSpinner);
        mDdlDate = findViewById(R.id.ddl_date);
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

            newTask = new Task(title, 0, detail, tag, deadLine, remindMark, dateToRemind);

            Log.d(LOG_TAG, newTask.toString());
            Log.d(LOG_TAG, "New Task create successful");
            Log.d(LOG_TAG, "-------");
            saveNewTask();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
            LocalDate remindDate;
            long delay;
            // if isRemind, notify at remind date, if not, notify at 6 hour before ddl
            if (!isRemind){
                remindDate = LocalDate.parse(deadLine, dateTimeFormatter);
                delay = remindDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
                        - System.currentTimeMillis() - SIX_HOURS;
            } else {
                remindDate = LocalDate.parse(dateToRemind, dateTimeFormatter);
                delay = remindDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
                        - System.currentTimeMillis();
            }

            mTaskViewModel.setReminder(delay, mTaskTitle.getText().toString(),
                    mTaskDetail.getText().toString());

            Log.d(LOG_TAG, "End Create new Task");
            finish();
        }
    }

    public void cancelCreate(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void saveNewTask(){
        mTaskRepository.insert(newTask);
    }

    private void setTaskProperties(Task curTask){
        mTaskTitle.setText(curTask.getTitle());
        mTaskDetail.setText(curTask.getDetail());
        mTagSpinner.setSelection(curTask.getTagPosition());
        mDdlDate.setText(curTask.getDeadLine());
        if (toBoolean(curTask.getIsRemind())) {
            mIsRemind.setSelected(true);
            mRemind_date.setText(curTask.getDateToRemind());
        } else {
            mIsRemind.setSelected(false);
        }
        status = curTask.getStatus();
    }

    private boolean toBoolean(int i){
        if (i == 1)
            return true;
        return false;
    }

    private String reformatDateString(String initial) {
        return initial.replaceAll("/", "-");
    }
}