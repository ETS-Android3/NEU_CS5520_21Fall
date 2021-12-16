package edu.neu.khoury.madsea.BingfanTian.Utils;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Adapter.TaskAdapter;
import edu.neu.khoury.madsea.BingfanTian.Database.TaskRepository;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnItemClickListener {

    public static final String TEXT_SEND = "newTask";

    private RecyclerView mTasksRecyclerView;
    private TaskAdapter mTasksAdapter;
    private List<Task> mTasksList;
    private TaskRepository mTaskRepository;
    private SearchView mSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTasksList = new ArrayList<>();

        mTasksRecyclerView = findViewById(R.id.task_list);

        mTaskRepository = new TaskRepository(this);

        mSearchView = findViewById(R.id.search_bar);

        initRecyclerView();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                retrieveKeyTasks(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                retrieveTasks();
                return false;
            }

        });

        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                retrieveTasks();
                return false;
            }
        });

        retrieveTasks();
    }

    public void addNewTask(View view) {
        Intent intent = new Intent(this, New_Task.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Task curTask = mTasksList.get(position);
        Intent intent = new Intent(this, Task_Detail.class);
        intent.putExtra(TEXT_SEND, curTask);
        startActivity(intent);
    }

    public void editTask(int position) {
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

    private void retrieveKeyTasks(String key){
        mTaskRepository.getKeyTasks(key).observe(this, new Observer<List<Task>>() {
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
        new ItemTouchHelper(itemTouchHelperDeleteCallBack).attachToRecyclerView(mTasksRecyclerView);
        new ItemTouchHelper(itemTouchHelperEditCallBack).attachToRecyclerView(mTasksRecyclerView);
        mTasksAdapter = new TaskAdapter(mTasksList, this);
        mTasksRecyclerView.setAdapter(mTasksAdapter);
    }


    private void deleteTask(int id){
        mTasksList.remove(id);
        mTasksAdapter.notifyDataSetChanged();
        mTaskRepository.deleteTaskById(id);
    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperDeleteCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Do you want to delete this todo task?");
            dialog.setMessage("Deleted tasks cannot be restored!");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    deleteTask(viewHolder.getAdapterPosition());
                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mTasksAdapter.notifyDataSetChanged();
                }
            });
            dialog.show();
        }

    };


    private ItemTouchHelper.SimpleCallback itemTouchHelperEditCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("Do you want to edit this todo task?");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editTask(viewHolder.getAdapterPosition());
                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mTasksAdapter.notifyDataSetChanged();
                }
            });
            dialog.show();
        }

    };
}