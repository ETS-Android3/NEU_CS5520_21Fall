package edu.neu.khoury.madsea.BingfanTian.Database;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Async.DeleteAsyncTask;
import edu.neu.khoury.madsea.BingfanTian.Async.InsertAsyncTask;
import edu.neu.khoury.madsea.BingfanTian.Async.UpdateAsyncTask;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;

public class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;
    private TaskDatabase db;

    public TaskRepository(Context context) {
        db = TaskDatabase.getInstance(context);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    public void insertTask(Task task){
        new InsertAsyncTask(db.taskDao()).execute(task);
    }

    public void updateTask(Task task){
        new UpdateAsyncTask(db.taskDao()).execute(task);
    }

    public LiveData<List<Task>> retrieveTasks() {
        return mAllTasks;
    }

    public void deleteTask(Task task){
        new DeleteAsyncTask(db.taskDao()).execute(task);
    }
}
