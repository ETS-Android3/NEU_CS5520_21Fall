package edu.neu.khoury.madsea.BingfanTian.Async;

import android.os.AsyncTask;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskDao;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;

public class DeleteAsyncTask extends AsyncTask<Task, Void, Void> {
    private TaskDao mTaskDao;
    public DeleteAsyncTask(TaskDao dao) {
        mTaskDao = dao;
    }

    @Override
    protected Void doInBackground(Task... tasks) {
        mTaskDao.deleteTask(tasks);
        return null;
    }
}
