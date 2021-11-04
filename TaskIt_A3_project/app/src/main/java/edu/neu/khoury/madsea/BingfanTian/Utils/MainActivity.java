package edu.neu.khoury.madsea.BingfanTian.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Adapter.TaskAdapter;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskRepository;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskViewModel;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnItemClickListener {

    public static final String TEXT_SEND = "newTask";

    private RecyclerView mTasksRecyclerView;
    private TaskAdapter mTasksAdapter;
    private List<Task> mTasksList;
    private TaskRepository mTaskRepository;
    private TaskViewModel mTaskViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTasksList = new ArrayList<>();

        mTasksRecyclerView = findViewById(R.id.task_list);

        mTaskRepository = new TaskRepository(this);

        initRecyclerView();
        retrieveTasks();
    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, New_Task.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Task curTask = mTasksList.get(position);
        Intent intent = new Intent(this, Edit_Task.class);
        intent.putExtra(TEXT_SEND, curTask);
        startActivity(intent);
    }

    private void retrieveTasks(){
        mTaskRepository.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@NonNull List<Task> tasks) {
                if (mTasksList.size() > 0){
                    mTasksList.clear();
                }
                if (tasks != null){
                    mTasksList.addAll(tasks);
                }
                mTasksAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mTasksRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(20);
        mTasksRecyclerView.addItemDecoration(itemDecorator);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mTasksRecyclerView);
        mTasksAdapter = new TaskAdapter(mTasksList, this);
        mTasksRecyclerView.setAdapter(mTasksAdapter);
    }


    private void deleteTask(int id){
        mTasksList.remove(id);
        mTasksAdapter.notifyDataSetChanged();
        mTaskRepository.deleteTaskById(id);
    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteTask(viewHolder.getAdapterPosition());
        }
    };
}