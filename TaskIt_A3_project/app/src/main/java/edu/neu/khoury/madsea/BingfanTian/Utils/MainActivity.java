package edu.neu.khoury.madsea.BingfanTian.Utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Adapter.Task_Adapter;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskListAdapter;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskViewModel;
import edu.neu.khoury.madsea.BingfanTian.Database.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> itemsAdapter;
    private ListView lvItems;

    public static final String TEXT_SEND = "newTask";
    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;

    private RecyclerView tasksRecyclerView;
    private TaskViewModel mTaskViewModel;
    private Task_Adapter tasksAdapter;
    private List<Task> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();

        tasksList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.task_list);
//        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        tasksAdapter = new Task_Adapter(this);
//        tasksRecyclerView.setAdapter(tasksAdapter);

//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final TaskListAdapter adapter = new TaskListAdapter(new TaskListAdapter.TaskDiff());
        tasksRecyclerView.setAdapter(adapter);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTaskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        mTaskViewModel.getAllTasks().observe(this, tasks -> {
            adapter.submitList(tasks);
        });
//        tasksAdapter.setOnItemClickListener(new Task_Adapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Task curTask = tasksList.get(position);
//                Intent intent = new Intent(MainActivity.this, Edit_Task.class);
//                intent.putExtra(TEXT_SEND, (Serializable) curTask);
//                startActivity(intent);
//            }
//        });
//
//        // create some sample data
//        Task task1 = new Task(0, "titel1", "this is a sample task",
//                0, new Date(), 0, null);
//        Task task2 = new Task(0, "titel2", "this is a sample task",
//                1, new Date(), 0, null);
//        tasksList.add(task1);
//        tasksList.add(task2);
//
//        tasksAdapter.setTaskList(tasksList);
    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, New_Task.class);
        startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Task reply = (Task) data.getSerializableExtra(New_Task.EXTRA_REPLY);
            mTaskViewModel.insert(reply);
        } else{
            Toast.makeText(
                    getApplicationContext(),
                    "Empty task!",
                    Toast.LENGTH_LONG).show();
        }
//
//        if (requestCode == TEXT_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                Task reply = (Task) data.getSerializableExtra(New_Task.EXTRA_REPLY);
//                tasksList.add(reply);
//                tasksAdapter.setTaskList(tasksList);
//            }
//        }
    }

}