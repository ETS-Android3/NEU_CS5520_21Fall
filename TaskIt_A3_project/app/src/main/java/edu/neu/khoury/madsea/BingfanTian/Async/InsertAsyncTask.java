package edu.neu.khoury.madsea.BingfanTian.Async;

import android.nfc.Tag;
import android.os.AsyncTask;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskDao;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;

public class InsertAsyncTask extends AsyncTask<Task, Void, Void> {

    private TaskDao mTaskDao;
    public InsertAsyncTask(TaskDao dao) {
        mTaskDao = dao;
    }

    @Override
    protected Void doInBackground(Task... tasks) {
        mTaskDao.insert(tasks);
        return null;
    }
}
