package edu.neu.khoury.madsea.BingfanTian;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TasksAdapter extends ArrayAdapter<Task> {

    public TasksAdapter(@NonNull Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Task cur_task = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task,
                    parent, false);
        TextView item_title = (TextView) convertView.findViewById(R.id.item_title);
        TextView item_sub = (TextView) convertView.findViewById(R.id.item_sub_title);
        item_title.setText(cur_task.getTitle());
        item_sub.setText(cur_task.getDeadLine().toString());

        return convertView;
    }
}