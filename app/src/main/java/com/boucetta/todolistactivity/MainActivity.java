package com.boucetta.todolistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button adTaskbtn, seeListbtn;
    EditText editTextTask, editTextDelay;
    Dbmanager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Set your to do list");
        adTaskbtn = findViewById(R.id.AddTaskButton);
        seeListbtn = findViewById(R.id.SeeListTasksButton);
        editTextDelay = findViewById(R.id.editTextDelay);
        editTextTask = findViewById(R.id.editTextTask);
        dbmanager = new Dbmanager(MainActivity.this);







        adTaskbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString().replace("'"," ");
                String delay = editTextDelay.getText().toString().replace("'"," ");

                if (editTextDelay.getText().toString().isEmpty() && editTextDelay.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please gives the task and the delay",
                            Toast.LENGTH_LONG).show();

                }

                else {

                    dbmanager.addTask(task, delay);

                    editTextDelay.setText("");
                    editTextTask.setText("");

                }

            }
        });

        seeListbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListTasks.class);
                startActivity(intent);


            }
        });
    }
}