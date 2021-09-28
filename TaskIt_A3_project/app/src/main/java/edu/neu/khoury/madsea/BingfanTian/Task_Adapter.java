package edu.neu.khoury.madsea.BingfanTian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.ViewHolder> {

    private List<Task> taskList;
    private  MainActivity activity;
    private final java.text.SimpleDateFormat formatter =
            new SimpleDateFormat( "EEE MM-dd-yyyy");

    public Task_Adapter(MainActivity activity){
        this.activity = activity;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Task cur_task = taskList.get(position);
        holder.taskTitle.setText(cur_task.getTitle());
        holder.taskDeadline.setText(formatter.format(cur_task.getDeadLine()));
        holder.taskCheckBox.setSelected(toBoolean(cur_task.getStatus()));
    }

    public int getItemCount(){
        return taskList.size();
    }

    private boolean toBoolean(int n){
        return n!=0;
    }

    public void setTaskList(List<Task> newList){
        this.taskList = newList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox taskCheckBox;
        TextView taskTitle;
        TextView taskDeadline;

        ViewHolder(View view) {
            super(view);
            taskCheckBox = view.findViewById(R.id.taskCheckBox);
            taskTitle = view.findViewById(R.id.item_title);
            taskDeadline = view.findViewById(R.id.item_sub_title);
        }
    }
}
