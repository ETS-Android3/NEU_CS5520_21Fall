package edu.neu.khoury.madsea.BingfanTian.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.neu.khoury.madsea.BingfanTian.Models.Task;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "task_db";

    private static TaskDatabase instance;

    static TaskDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class, DATABASE_NAME).build();
        }
        return instance;
    }

    public abstract TaskDao taskDao();
//
//    private static volatile TaskDatabase INSTANCE;
//    private static final int NUMBER_OF_THREADS = 4;
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
//    public static TaskDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (TaskDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            TaskDatabase.class, "task_database")
//                            .addCallback(sRoomDatabaseCallback).build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            databaseWriteExecutor.execute(() -> {
//                TaskDao dao = INSTANCE.taskDao();
//                dao.deleteAll();
//
//                Task task1 = new Task("titel1", 0, "this is a sample task",
//                        0, new Date().toString(), 0, null);
//                Task task2 = new Task("titel2", 0, "this is a sample task",
//                        1, new Date().toString(), 0, null);
//
//                dao.insert(task1);
//                dao.insert(task2);
//            });
//        }
//    };
}
