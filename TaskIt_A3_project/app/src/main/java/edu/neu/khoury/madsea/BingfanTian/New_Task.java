package edu.neu.khoury.madsea.BingfanTian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class New_Task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }

    public void createNewTask(View view) {
    }

    public void cancelCreate(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}