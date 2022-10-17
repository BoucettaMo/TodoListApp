package com.boucetta.todolistactivity;

public class ListModal {

    String task;
    String delay;

    public ListModal(String task, String delay) {
        this.task = task;
        this.delay = delay;
    }

    int id;

    public String getTask() {
        return task;
    }

    public String getDelay() {
        return delay;
    }

    public int getId() {
        return id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setId(int id) {
        this.id = id;
    }



}
