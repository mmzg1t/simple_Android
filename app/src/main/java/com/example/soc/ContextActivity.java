package com.example.soc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        ImageView imageView = findViewById(R.id.ima);
        TextView  textView=findViewById(R.id.newsContent);
        int imageRes = intent.getIntExtra("image", 0);

        if (name!=null){
            textView.setText(name);
        }
        if (imageRes != 0) {
            imageView.setImageResource(imageRes); // 设置图片资源
        }
    }

}