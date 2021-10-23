package com.example.appgrade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> ExampleList;
    private OnItemClickListener Listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { Listener = listener;}

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView ClassName;
        public TextView GradeLevel;

        public ExampleViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            ClassName = itemView.findViewById(R.id.className);
            GradeLevel = itemView.findViewById(R.id.gradeLvl);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        ExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, Listener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = ExampleList.get(position);

        holder.ClassName.setText(currentItem.getClassName());
        holder.GradeLevel.setText(currentItem.getGradeLvl());
    }

    @Override
    public int getItemCount() {
        return ExampleList.size();
    }
}