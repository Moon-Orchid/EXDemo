package com.mo.exdemo.ex.Ex6_4_ListView;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;


/**
 * FileName: simpleCursorAdapter
 * Package Name: com.mo.exdemo.ex.Ex6_4_ListView
 * Founder: MoonOrchid
 * Create Date: 2020/9/27-18:37
 * Profile: 列表视图: SimpleCursorAdapter
 **/
public class simpleCursorAdapter extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplecusoradapter);

        listView = findViewById(R.id.simpleCursorAdapterList);

        initView();
    }

    private void initView() {
        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        startManagingCursor(cursor);

        ListAdapter listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                cursor,
                new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME},
                new int[]{android.R.id.text1});
        listView.setAdapter(listAdapter);
    }
}
