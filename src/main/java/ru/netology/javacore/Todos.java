package ru.netology.javacore;

import java.util.*;

public class Todos {
    private List<String> taskList = new ArrayList<>();

    public void addTask(String task) {
        if (task == null) {
            throw new IllegalArgumentException("Не введён тип задачи");
        }
        taskList.add(task);
    }

    public void removeTask(String task) {
        if (task == null) {
            throw new IllegalArgumentException("Не введён тип задачи");
        }
        taskList.remove(task);
    }

    public String getAllTasks() {
        return taskList.stream()
                .sorted()
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }
}
