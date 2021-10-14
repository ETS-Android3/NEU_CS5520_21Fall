package edu.neu.khoury.madsea.BingfanTian.Async;

import android.nfc.Tag;
import android.os.AsyncTask;

import edu.neu.khoury.madsea.BingfanTian.Database.TaskDao;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;

public class UpdateAsyncTask extends AsyncTask<Task, Void, Void> {

    private TaskDao mTaskDao;
    public UpdateAsyncTask(TaskDao dao) {
        mTaskDao = dao;
    }

    @Override
    protected Void doInBackground(Task... tasks) {
        mTaskDao.update(tasks);
        return null;
    }
}
