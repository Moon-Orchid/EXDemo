package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex5_7
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/16-23:25
 * Profile: 日期控件
 **/
public class Ex5_7 extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    Button getDate1,getTime1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_7);

        datePicker = findViewById(R.id.datePicker1);
        timePicker = findViewById(R.id.timePicker1);
        getDate1 = findViewById(R.id.getData1);
        getTime1 = findViewById(R.id.getTime1);
    }

    public void getData(View view) {
        String date;
        date = datePicker.getYear()+"年"+(datePicker.getMonth()+1)+"月"+datePicker.getDayOfMonth()+"日";
        getDate1.setText(date);
    }

    public void getTime(View view) {
        String time;
        time = timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        getTime1.setText(time);
    }
}
