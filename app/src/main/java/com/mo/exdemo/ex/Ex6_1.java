package com.mo.exdemo.ex;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;
import com.mo.exdemo.util.ShellTokenizer;

/**
 * FileName: Ex6_1
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/17-8:58
 * Profile: 两种自动完成文本
 **/
public class Ex6_1 extends AppCompatActivity {

    private String[] autoStr = {"北京", "上海", "沈阳", "西安", "双辽"};
    //使用
    //private String[] autoStr = getResources().getStringArray(R.array.onepiece);


    private AutoCompleteTextView myAutoTextView;
    private MultiAutoCompleteTextView myMultiTextView;
    /**
     * 默认分词器{@link MultiAutoCompleteTextView.CommaTokenizer}
     * 自定义分词器{@link ShellTokenizer},可以外部指定分隔符
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_1);

        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, autoStr);

        myAutoTextView = findViewById(R.id.autoCompleteTextView);
        myMultiTextView = findViewById(R.id.multiAutoCompleteTextView);

        myAutoTextView.setAdapter(list);
        myAutoTextView.setThreshold(1);

        myMultiTextView.setAdapter(list);// 设置数据适配器
        // 设置分词器，默认为逗号+空格
        //myMultiTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        //自定义分词器的使用
        myMultiTextView.setTokenizer(new ShellTokenizer(this, '-', true));    // 只有分词符，不额外加空格
        myMultiTextView.setThreshold(1);// 设置触发提示阈值

    }
}
