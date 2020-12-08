package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex7_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/8-8:58
 * Profile:
 **/
public class Ex7_2 extends AppCompatActivity {

    private EditText editText;
    private String tempStr = "";
    private TextView textView;
    private String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex7_2);

        textView = findViewById(R.id.ex7_2_textView1);
        editText = findViewById(R.id.ex7_2_editText1);

        //注册
        this.registerForContextMenu(findViewById(R.id.ex7_2_textView1));
        this.registerForContextMenu(findViewById(R.id.ex7_2_editText1));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderIcon(R.drawable.ic_launcher_background);
        if (v == findViewById(R.id.ex7_2_textView1)) {
            menu.add(0, 1, 0, "火车");
            menu.add(0, 2, 0, "飞机");
            menu.add(0, 3, 0, "骑行");
            menu.add(0, 4, 0, "步行");
        }
        if (v == findViewById(R.id.ex7_2_editText1)) {
            menu.add(0, 5, 0, "复制");
            menu.add(0, 6, 0, "删除");
            menu.add(0, 7, 0, "粘贴");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (editText.getText().toString().equals("")) {
                    tempStr = "";
                }
                if (!tempStr.isEmpty()) {
                    tempStr += "，" + item.getTitle().toString().trim();
                } else {
                    tempStr += item.getTitle().toString().trim();
                }
                editText.setText(tempStr);
                break;
            case 5:
                str = editText.getText().toString().trim();
                break;
            case 6:
                tempStr = "";
                editText.setText("");
                break;
            case 7:
                if (str.isEmpty()) {
                    Toast.makeText(this, "剪切板没有内容", Toast.LENGTH_SHORT).show();
                } else {
                    editText.setText(editText.getText().toString() + str);

                }
                break;
        }
        return true;
    }
}
