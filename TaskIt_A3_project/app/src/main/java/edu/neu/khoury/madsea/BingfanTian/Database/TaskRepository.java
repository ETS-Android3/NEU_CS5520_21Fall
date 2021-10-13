package edu.neu.khoury.madsea.BingfanTian.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {

    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    TaskRepository(Application application) {
        TaskDatabase db = TaskDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    void insert(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            mTaskDao.insert(task);
        });
    }
}
