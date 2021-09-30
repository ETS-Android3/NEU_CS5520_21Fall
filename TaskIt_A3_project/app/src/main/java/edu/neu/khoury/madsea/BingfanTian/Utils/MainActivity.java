package edu.neu.khoury.madsea.BingfanTian.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Adapter.Task_Adapter;
import edu.neu.khoury.madsea.BingfanTian.Model.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> itemsAdapter;
    private ListView lvItems;

    public static final int TEXT_REQUEST = 1;
    public static final String TEXT_SEND = "extra_Task";
    // new
    private RecyclerView tasksRecyclerView;
    private Task_Adapter tasksAdapter;
    private List<Task> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.task_list);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new Task_Adapter(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        tasksAdapter.setOnItemClickListener(new Task_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Task curTask = tasksList.get(position);
                Intent intent = new Intent(MainActivity.this, Edit_Task.class);
                intent.putExtra(TEXT_SEND, (Serializable) curTask);
                startActivity(intent);
            }
        });
        Task task1 = new Task(1, 0, "titel1", "this is a sample task",
                0, new Date(), false, null);
        Task task2 = new Task(2, 0, "titel2", "this is a sample task",
                1, new Date(), false, null);
        tasksList.add(task1);
        tasksList.add(task2);

        tasksAdapter.setTaskList(tasksList);
    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, New_Task.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Task reply = (Task) data.getSerializableExtra(New_Task.EXTRA_REPLY);
                tasksList.add(reply);
                tasksAdapter.setTaskList(tasksList);
            }
        }
    }

}