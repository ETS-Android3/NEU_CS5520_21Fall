package edu.neu.khoury.madsea.BingfanTian.Database;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import edu.neu.khoury.madsea.BingfanTian.Models.Task;

public class TaskRepository {
    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;

    public TaskRepository(Context context) {
//        context.deleteDatabase("task_database");
        TaskDatabase db = TaskDatabase.getInstance(context);
        taskDao = db.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }


    public void insert(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.insert(task);
        });
    }

    public Task findTaskById(int id) throws ExecutionException, InterruptedException {
        Callable<Task> callable = new Callable<Task>() {
            @Override
            public Task call() throws Exception {
                return taskDao.findTaskById(id);
            }
        };
        ExecutorService es = TaskDatabase.databaseWriteExecutor;
        Future<Task> submit = es.submit(callable);
        return submit.get();
    }

    public void deleteAll() {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.deleteAll();
        });
    }

    public void deleteTaskById(int id) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.deleteTaskById(id);
        });
    }

    public void update(Task task, int index) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.updateTask(task.getTitle(), task.getDetail(), task.getTagPosition(), task.getDeadLine()
                    , task.getStatus(), index);
        });
    }

    public int getFirstIndex() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return taskDao.getFirstIndex();
            }
        };
        ExecutorService es = TaskDatabase.databaseWriteExecutor;
        Future<Integer> submit = es.submit(callable);
        return submit.get();
    }

    public void updateStatus(int position) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.updateStatus(position);
        });
    }
}
