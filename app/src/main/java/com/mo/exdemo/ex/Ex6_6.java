package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_6
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-19:40
 * Profile: 进度条与滑块
 **/
public class Ex6_6 extends AppCompatActivity {


    private Button button;
    private SeekBar seekBar;
    private ProgressBar firstBar;
    private ProgressBar secondBar;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_6);

        button = findViewById(R.id.button26);
        seekBar = findViewById(R.id.seekBar);
        firstBar = findViewById(R.id.progressBar2);
        secondBar = findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    firstBar.setVisibility(View.VISIBLE);
                    secondBar.setVisibility(View.VISIBLE);
                } else if (i <= 100) {
                    firstBar.setProgress(i);
                    firstBar.setSecondaryProgress(i + 10);
                    secondBar.setProgress(i);
                }
                i = i + 10;
                seekBar.setProgress(i);
            }
        });
    }
}
