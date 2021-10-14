package edu.neu.khoury.madsea.BingfanTian.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.neu.khoury.madsea.BingfanTian.Utils.MainActivity;
import edu.neu.khoury.madsea.BingfanTian.Models.Task;
import edu.neu.khoury.madsea.BingfanTian.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>
        implements View.OnClickListener{

    private List<Task> mTaskList = new ArrayList<>();
    private MainActivity activity;
    private final java.text.SimpleDateFormat formatter =
            new SimpleDateFormat( "EEE MM-dd-yyyy");
    private OnItemClickListener mOnItemClickListener;

    public TaskAdapter(List<Task> taskList, OnItemClickListener onItemClickListener){
        this.mTaskList = taskList;
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Task cur_task = mTaskList.get(position);
        holder.taskTitle.setText(cur_task.getTitle());
        holder.taskDeadline.setText(cur_task.getDeadLine());
        holder.taskCheckBox.setChecked(toBoolean(cur_task.getStatus()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount(){
        return mTaskList.size();
    }

    private boolean toBoolean(int n){
        return n!=0;
    }

    public void setTaskList(List<Task> newList){
        this.mTaskList = newList;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CheckBox taskCheckBox;
        TextView taskTitle;
        TextView taskDeadline;

        OnItemClickListener onItemClickListener;

        ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);
            taskCheckBox = view.findViewById(R.id.taskCheckBox);
            taskTitle = view.findViewById(R.id.item_title);
            taskDeadline = view.findViewById(R.id.item_sub_title);
            this.onItemClickListener = onItemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    //define interface
    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}