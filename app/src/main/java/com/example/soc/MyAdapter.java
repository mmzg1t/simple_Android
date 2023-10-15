package com.example.soc;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<String> list;
    private View inflater;
    private Context context;

    //构造方法
    public MyAdapter(Context context,List<String> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        inflater = LayoutInflater.from(context).inflate(R.layout.item_dome,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }


    //将数据绑定到 RecyclerView 的视图项上
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        holder.textView.setGravity(Gravity.CENTER);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        // 因为行里面的内容只有一个TextView，所以这里只用找到TextView就可以
        TextView textView;
        public MyViewHolder(View itemView){
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }
    }


}
