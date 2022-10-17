package com.boucetta.todolistactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListTasks extends AppCompatActivity {

    private ArrayList<ListModal> listModalArrayList;
    private Dbmanager dbmanager;
    private ListAdapter listAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tasks);
        setTitle("My to do list");

        listModalArrayList = new ArrayList<>();
        dbmanager = new Dbmanager(ListTasks.this);

        // getting our course array
        // list from db handler class.
        listModalArrayList = dbmanager.readCourses();

        // on below line passing our array lost to our adapter class.
        listAdapter = new ListAdapter(listModalArrayList, ListTasks.this);
        recyclerView = findViewById(R.id.idRVLists);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListTasks.this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recyclerView.setAdapter(listAdapter);





    }
}