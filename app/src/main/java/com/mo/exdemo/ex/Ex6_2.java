package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/17-9:41
 * Profile:
 **/
public class Ex6_2 extends AppCompatActivity {

    private TextView textView;

    String[] cityList = {"","10:10", "10:20", "10:30"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_2);

        Spinner spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.spinnerText);

        final ArrayAdapter<String> AdapterList = new ArrayAdapter<String>(
                this,
                android.R.layout.select_dialog_item,
                cityList);
        spinner.setAdapter(AdapterList);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("我的上课时间:" + cityList[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
