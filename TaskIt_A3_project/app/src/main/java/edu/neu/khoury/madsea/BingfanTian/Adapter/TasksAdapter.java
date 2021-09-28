package edu.neu.khoury.madsea.BingfanTian.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.neu.khoury.madsea.BingfanTian.Model.Task;
import edu.neu.khoury.madsea.BingfanTian.R;



/* ====================
 *   this version is created for listView,
 *   it will not be used, because now i'm using recyclerView,
 *   just for a backup
 *
 */
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
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "EEE MM-dd-yyyy");
        item_sub.setText(reformatDateString(formatter.format(cur_task.getDeadLine())));
        return convertView;
    }

    private String reformatDateString(String initial){
        String result = initial.replaceAll("-", "/");
        return result;
    }
}
