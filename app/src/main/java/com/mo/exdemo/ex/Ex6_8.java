package com.mo.exdemo.ex;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_8
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-19:40
 * Profile: Gallery画廊控件
 **/
public class Ex6_8 extends AppCompatActivity {

    private Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_8);

        gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ex6_8.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class ImageAdapter extends BaseAdapter {

        private Context context;
        //声明一个整数数组，用来存放显示的图片ID
        private Integer[] mImage = {
                R.drawable.adimg,
                R.drawable.adimg,
                R.drawable.adimg,
                R.drawable.adimg,
                R.drawable.adimg,
                R.drawable.adimg,
                R.drawable.adimg,
        };

        public ImageAdapter(Context c) {
            context = c;
        }

        //获取该适配器中图片数量
        @Override
        public int getCount() {
            return mImage.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //显示相应位置的图片
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //声明一个ImageView控件
            ImageView i = new ImageView(context);
            //设置ImageView的图片资源ID为改ImageView显示的内容
            i.setImageResource(mImage[position]);
            //控制图片适合ImageView的大小拉伸图片(不按比例),以填充View的宽和高。
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            //设置ImageView的布局参数
            i.setLayoutParams(new Gallery.LayoutParams(800, 800));
            return i;
        }
    }
}
