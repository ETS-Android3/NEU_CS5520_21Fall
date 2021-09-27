package edu.neu.khoury.madsea.BingfanTian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.taskList);
        tasks = new ArrayList<Task>();
        // add data
        Task task1 = new Task("titel1", "this is a sample task", "tag1"
                , new Date(2021, 1, 1), false, null);
        Task task2 = new Task("titel2", "this is a sample task", "tag1"
                , new Date(2021, 2, 2), false, null);
        tasks.add(task1);
        tasks.add(task2);

        TasksAdapter adapter = new TasksAdapter(this, tasks);
        ListView listView = (ListView) findViewById(R.id.taskList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int positionNum = i;
                Intent intent = new Intent(MainActivity.this, Edit_Task.class);
//                intent.putExtra("extra_positionNum", positionNum);
                startActivity(intent);
            }
        });

    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, New_Task.class);
        startActivity(intent);
    }
}