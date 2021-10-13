package edu.neu.khoury.madsea.BingfanTian.Database;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class TaskListAdapter extends ListAdapter<Task, TaskViewHolder> {

    public TaskListAdapter(@NonNull DiffUtil.ItemCallback<Task> diffCallBack){
        super(diffCallBack);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TaskViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task current = getItem(position);
        holder.bind(current.getTitle(), current.getStatus(), current.getDeadLine());
    }

    public static class TaskDiff extends DiffUtil.ItemCallback<Task> {

        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDeadLine().equals(newItem.getDeadLine()) &&
                    oldItem.getTagPosition() == newItem.getTagPosition();
        }
    }
}
