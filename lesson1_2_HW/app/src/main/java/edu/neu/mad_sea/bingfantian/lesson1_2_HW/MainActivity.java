package edu.neu.mad_sea.bingfantian.lesson1_2_HW;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button countButton;
    private Button zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        countButton = (Button) findViewById(R.id.button_count);
        zeroButton = (Button) findViewById(R.id.button_zero);
    }

    /*
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void countUp(View view) {
        mCount++;
        if (mCount > 0)
            zeroButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount % 2 == 1)
            //countButton.setBackgroundColor(getResources().getColor(R.color.green));
            view.setBackgroundColor(getResources().getColor(R.color.green));
        else
            //countButton.setBackgroundColor(getResources().getColor(R.color.blue));
            view.setBackgroundColor(getResources().getColor(R.color.blue));
    }

    /*
     * Set the number to 0 in the TextView when the Zero button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void setZero(View view) {
        mCount = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        //zeroButton.setBackgroundColor(getResources().getColor(R.color.grey));
        view.setBackgroundColor(getResources().getColor(R.color.grey));
        countButton.setBackgroundColor(getResources().getColor(R.color.blue));
    }
}