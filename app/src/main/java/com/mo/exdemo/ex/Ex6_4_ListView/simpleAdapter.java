package com.mo.exdemo.ex.Ex6_4_ListView;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: simpleAdapter
 * Package Name: com.mo.exdemo.ex.Ex6_4_ListView
 * Founder: MoonOrchid
 * Create Date: 2020/9/27-18:35
 * Profile: 列表视图: simpleAdapter
 **/
public class simpleAdapter extends AppCompatActivity {

    private ListView listView;

    //是否屏蔽符号
    private final boolean PHONE_DOWN = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);

        //获得arrayList控件的引用
        listView = findViewById(R.id.simpleAdapterList);

        initView();

    }

    private void initView() {

        //定义游标，用于获取手机的通讯录。
        /**
         * 在数据处理中，Android经常会使用ContentProvider的方式.
         * ContentProvider使用Uri实例作为句柄的数据封装，很方便的进行增、删、改、查操作.
         *
         * Android通过ContentProvider重数据的封装中获取信息.
         * GetContentResolver()函数则是通过ContentProvider提供的URI接口来获取里面封装的数据.
         * ContactsContract.Contents.CONTENT_URI为联系人数据库提供的URI.
         */
        Cursor cursor = getContentResolver()
                .query(ContactsContract.Contacts.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
        //打开游标访问联系人数据库，该函数的作用是让Activity自身来管理游标.
        startManagingCursor(cursor);

        //定义Map类型的列表，用于存放从联系人数据库读取出的联系人信息.
        List<Map<String, Object>> phoneList = new ArrayList<Map<String, Object>>();

        //从联系人数据库读取联系人信息。使用游标进行循环，读取联系人信息。
        while (cursor.moveToNext()) {

            String PhoneInfo = "";
            //定义哈希表
            Map<String, Object> map = new HashMap<String, Object>();
            //获取联系人姓名
            int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            String name = cursor.getString(nameFieldColumnIndex);
            //将姓名放入哈希表姓名一列
            map.put("name", name);

            //获取联系人ID
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            //获取某联系人的联系电话，因为一个人可能有多个联系电话，
            //所以用一个游标进行循环，遍历改联系人的所有联系电话。
            Cursor phone = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId,
                    null,
                    null
            );
            while (phone.moveToNext()) {
                //获取每一个联系电话
                String strPhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                if (PHONE_DOWN) {
                    //去除号码间的空格、横杠、区号、括号
                    strPhoneNumber = strPhoneNumber.replace("+86", "")
                            .replace(" ", "")
                            .replace("-", "")
                            .replace("(", "")
                            .replace(")", "");
                }
                //将该联系人的联系电话连接成一个字符串
                PhoneInfo += strPhoneNumber + "\n";
            }

            //将联系电话放入哈希表的phone一列
            map.put("phone", PhoneInfo);
            //关闭游标
            phone.close();
            //将哈希表放入phoneList列表
            phoneList.add(map);
        }

        //关闭外层循环的游标
        cursor.close();
        /**
         * 定义一个SimpleAdapter适配器,将生成的phoneList作为该适配器的数据源，
         * 采用R.layout.list作为LIstItem的XML实现，
         * “String[]{"name","phone"},new int[]{R.id.name,R.id.phone}”定义动态数组与ListItem对应的子项。
         */
        SimpleAdapter listAdapter = new SimpleAdapter(
                this,
                phoneList,
                R.layout.list,
                new String[]{"name","phone"},
                new int[]{R.id.name,R.id.phone});
        //将ListView的适配器设置为listAdapter的适配器
        listView.setAdapter(listAdapter);
    }
}
