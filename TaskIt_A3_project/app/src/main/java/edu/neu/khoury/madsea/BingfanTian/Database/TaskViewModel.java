package edu.neu.khoury.madsea.BingfanTian.Database;

import static edu.neu.khoury.madsea.BingfanTian.Notification.NotifyWorker.KEY_TASK_DETAILS;
import static edu.neu.khoury.madsea.BingfanTian.Notification.NotifyWorker.KEY_TASK_TITLE;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.Notification.NotifyWorker;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository taskRepository;
    private final LiveData<List<Task>> allTasks;
    private WorkManager mWorkManager;


    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
        allTasks = taskRepository.getAllTasks();
        mWorkManager = WorkManager.getInstance(application);
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        taskRepository.insert(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteTaskById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public void updateTask(Task task, int index) {
        taskRepository.update(task, index);
    }

    public Task findTaskById(int id) throws ExecutionException, InterruptedException {
        return taskRepository.findTaskById(id);
    }

    public int getFirstIndex() throws ExecutionException, InterruptedException {
        return taskRepository.getFirstIndex();
    }

    public void updateStatus(int position) {
        taskRepository.updateStatus(position);
    }

    public void setReminder(long duration, String title, String details) {
        if (duration < 0) {
            duration = 0;
        }
        OneTimeWorkRequest sendNotificationRequest = new OneTimeWorkRequest.Builder(NotifyWorker.class)
                .setInitialDelay(duration, TimeUnit.MILLISECONDS)
                .setInputData(createInputDataForReminder(title, details))
                .build();
        mWorkManager.enqueue(sendNotificationRequest);
    }

    private Data createInputDataForReminder(String title, String details) {
        Data.Builder builder = new Data.Builder();
        builder.putString(KEY_TASK_TITLE, "Reminder for task: " + title);
        builder.putString(KEY_TASK_DETAILS, "Task details: " + details);
        return builder.build();
    }
}