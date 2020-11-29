package com.company.Lab23_24;

public class TaskItem {
    private int id;
    private String taskDescription;
    private String expression;

    public TaskItem(int id, String description, String expression) {
        this.id = id;
        this.taskDescription = description;
        this.expression = expression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String description) {
        this.taskDescription = description;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
