package com.boucetta.todolistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateTasks extends AppCompatActivity {
    Button updateButton, deleteButton;
    EditText taskEditText, delayEditText;
    Dbmanager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tasks);
        setTitle("Update to do list");
        updateButton = findViewById(R.id.UpdateTaskButton);
        deleteButton = findViewById(R.id.deleteTasksButton);
        taskEditText = findViewById(R.id.editTextTaskbis);
        delayEditText = findViewById(R.id.editTextDelaybis);
         dbmanager = new Dbmanager(UpdateTasks.this);

         taskEditText.setText(getIntent().getStringExtra("task"));
         delayEditText.setText(getIntent().getStringExtra("delay"));

         updateButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 dbmanager.updateCourse(getIntent().getStringExtra("task"),
                         taskEditText.getText().toString(), delayEditText.getText().toString());


                 // launching our main activity.
                 Intent i = new Intent(UpdateTasks.this, MainActivity.class);
                 startActivity(i);

             }
         });

         deleteButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dbmanager.deleteCourse(getIntent().getStringExtra("task"));

                 Intent i = new Intent(UpdateTasks.this, MainActivity.class);
                 startActivity(i);

             }
         });

    }
}