package com.example.nutritiousfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapater extends RecyclerView.Adapter<MyAdapater.MyViewHolder> {
    Context context;
    LayoutInflater layoutInflater;
    List<String> ids;
    public MyAdapater(Context context,List<String> ids){
        this.context=context;
        this.ids=ids;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.tv.setText(ids.get(position));
    }


    @Override
    public int getItemCount() {
        return ids.size();
    }
   public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.rvtv);
        }
    }
}
