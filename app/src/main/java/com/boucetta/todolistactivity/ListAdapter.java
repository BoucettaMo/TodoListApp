package com.boucetta.todolistactivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<ListModal> listModalArrayList;
    private Context context;

    // constructor
    public ListAdapter(ArrayList<ListModal> listModalArrayList, Context context) {
        this.listModalArrayList = listModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_simple,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {

        ListModal modal = listModalArrayList.get(position);
        holder.delayTV.setText(modal.getDelay());
        holder.taskTV.setText(modal.getTask());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateTasks.class);

                intent.putExtra("task",modal.getTask());
                intent.putExtra("delay",modal.getDelay());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listModalArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView taskTV, delayTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            taskTV = itemView.findViewById(R.id.idTVTask);
            delayTV = itemView.findViewById(R.id.idTVDelay);

        }

    }
}
