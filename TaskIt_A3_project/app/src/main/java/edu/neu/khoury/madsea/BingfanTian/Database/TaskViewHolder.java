package edu.neu.khoury.madsea.BingfanTian.Database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

import edu.neu.khoury.madsea.BingfanTian.R;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private CheckBox taskCheckBox;
    private TextView taskTitle;
    private TextView taskDeadline;

    private final int ZERO = 0;

    private TaskViewHolder(View itemView) {
        super(itemView);
        taskCheckBox = itemView.findViewById(R.id.taskCheckBox);
        taskTitle = itemView.findViewById(R.id.item_title);
        taskDeadline = itemView.findViewById(R.id.item_sub_title);
    }

    public void bind(String title, int status, String ddl) {
        taskTitle.setText(title);
        if (status == ZERO){
            taskCheckBox.setSelected(false);
        } else {
            taskCheckBox.setSelected(true);
        }
        taskDeadline.setText(ddl);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }
}
