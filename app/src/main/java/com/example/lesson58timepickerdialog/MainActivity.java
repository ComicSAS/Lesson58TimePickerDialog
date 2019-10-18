package com.example.lesson58timepickerdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.app.TimePickerDialog.OnTimeSetListener;

public class MainActivity extends AppCompatActivity {

    int DIALOG_TIME = 1;
    int myHour = 14;
    int myMinute = 35;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = findViewById(R.id.tvTime);
    }

    public void onclick(View view) {
        showDialog(DIALOG_TIME);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            return new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
        }
        return super.onCreateDialog(id);
    }

    OnTimeSetListener myCallBack = new OnTimeSetListener() {
        @SuppressLint("DefaultLocale")
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText(String.format("Time is %d hours %d minutes", myHour, myMinute));
        }
    };
}
