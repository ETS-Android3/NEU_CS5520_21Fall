package edu.neu.khoury.madsea.BingfanTian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewTask(View view) {
//        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, New_Task.class);
        startActivity(intent);
    }
}