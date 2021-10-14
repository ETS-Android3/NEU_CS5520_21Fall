package edu.neu.khoury.madsea.BingfanTian.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Models.Task;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task... task);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM task_table WHERE title = :title")
    List<Task> getTaskByTitle(String title);

    @Delete
    int deleteTask(Task... task);

    @Update
    int update(Task... task);
}
