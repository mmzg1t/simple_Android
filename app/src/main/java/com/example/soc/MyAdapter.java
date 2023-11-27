package com.example.soc;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<HashMap<String,Object>> list1;
    private final int[] icons;
    private  String[] name;
    private View inflater;
    private Context context;

    private AdapterView.OnItemClickListener  mlisterner;
    //构造方法
    public MyAdapter(Context context,String[] name,int[] icons){
        this.context=context;
        this.name=name;
        this.icons = icons;
    }

    // 创建新视图
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        inflater = LayoutInflater.from(context).inflate(R.layout.item_dome,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        // 因为行里面的内容只有一个TextView，所以这里只用找到TextView就可以
        private final ImageView imageView;
        private final TextView textView,textView1,textView2,textView3;
        public MyViewHolder(View itemView){
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.item_name);
            imageView=itemView.findViewById(R.id.iv);
            textView1.itemView.findViewById(R.id.textviewfile1);
            textView2.itemView.findViewById(R.id.textviewfile2);
            textView3.itemView.findViewById(R.id.textviewfile3);
        }
    }

    //定义一个接口用于回调操作
    public  interface  OnItemClickListener{
        void onClick(int pos);
    }




    //将数据绑定到 RecyclerView 的视图项上
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        HashMap<String,Object>dataItem=list1.get(position);
        String id =dataItem.get("id").toString();
        String name111 =dataItem.get("name").toString();
        String age=dataItem.get("age").toString();
        String itemText = name[position];
        holder.textView.setText(itemText);
        int iconResoure =icons[position];holder.imageView.setImageResource(iconResoure);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("touched","touch click name:" + position);
                Toast.makeText(context,"你点击了"+(position+1),Toast.LENGTH_SHORT).show();
                //mlisterner.onClick(position);
                // 创建 Intent，传递数据并启动新的 Activity
                Intent intent1=new Intent(context, MusicActivity.class);
                intent1.putExtra("name", name[position]);
                intent1.putExtra("image", icons[position]);
                Log.d("Debug", "position value: " + position);
                intent1.putExtra("position",position);
                context.startActivity(intent1); // 启动目标Activity
            }
        });
    }



    @Override
    public int getItemCount() {
        return name.length;
    }






}
