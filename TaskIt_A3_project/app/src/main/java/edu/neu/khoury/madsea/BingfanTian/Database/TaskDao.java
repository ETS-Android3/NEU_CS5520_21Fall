package edu.neu.khoury.madsea.BingfanTian.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Models.Task;

@Dao
public interface TaskDao {

    @Query("delete from task_table where id = " +
            "(select id from (select id from task_table order by id limit :id,1) as t)")
    void deleteTaskById(int id);

    @Query("delete from task_table")
    void deleteAll();

    @Query("select * from task_table where id = " +
            "(select id from (select id from task_table order by id limit :id,1) as t)")
    Task findTaskById(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("select * from task_table order by id")
    LiveData<List<Task>> getAllTasks();

    @Query("update task_table set title=:title, detail =:details, " +
            "tagPosition =:tag, deadLine =:deadline, isRemind =:isRemind, " +
            "dateToRemind =:dateToRemind where id =:index")
    void updateTask(String title, String details, int tag, String deadline, int isRemind,
                    String dateToRemind, int index);

    @Query("select id from task_table limit 1")
    int getFirstIndex();

    @Query("update task_table set status = not status where id =" +
            "(select id from (select id from task_table order by id limit :id,1) as t)")
    void updateStatus(int id);

    @Query("select * from task_table where title like '%' || :key || '%'order by id")
    LiveData<List<Task>> getKeyTasks(String key);
}
