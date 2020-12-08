package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex5_5
 * Package Name: com.mo.exdemo
 * Founder: MoonOrchid
 * Create Date: 2020/9/15-10:01
 * Profile: imageView透明度
 **/
public class Ex5_5 extends AppCompatActivity {

    ImageView imageView;
    float Alpha = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_5);
        imageView = findViewById(R.id.ImageTitle);
    }

    public void AlphaUp(View view) {
        if (Alpha <= 1) {
            Alpha = Alpha+0.1f;
            imageView.setAlpha(Alpha);
        }
    }

    public void AlphaDown(View view) {
        if (Alpha >= 0) {
            Alpha = Alpha - 0.1f;
            imageView.setAlpha(Alpha);
        }
    }
}
