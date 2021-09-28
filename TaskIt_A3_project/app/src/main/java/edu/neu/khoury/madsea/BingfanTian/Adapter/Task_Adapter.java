package edu.neu.khoury.madsea.BingfanTian.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Utils.MainActivity;
import edu.neu.khoury.madsea.BingfanTian.Model.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class Task_Adapter extends RecyclerView.Adapter<Task_Adapter.ViewHolder>
        implements View.OnClickListener{

    private List<Task> taskList;
    private MainActivity activity;
    private final java.text.SimpleDateFormat formatter =
            new SimpleDateFormat( "EEE MM-dd-yyyy");
    private OnItemClickListener mOnItemClickListener = null;

    public Task_Adapter(MainActivity activity){
        this.activity = activity;
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Task cur_task = taskList.get(position);
        holder.taskTitle.setText(cur_task.getTitle());
        holder.taskDeadline.setText(formatter.format(cur_task.getDeadLine()));
        holder.taskCheckBox.setSelected(toBoolean(cur_task.getStatus()));
        holder.itemView.setTag(position);
    }

    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
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
