package ru.netology.javacore;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TodosTests {

    @Test
    public void testNull() {
        Todos todos = new Todos();
        String task1 = "Включить чайник";
        String expected = "Включить чайник";
        todos.addTask(task1);

        assertNotNull(task1, expected);
    }

    @Test
    public void testAdd() {
        Todos todos = new Todos();
        String task1 = "Проснуться";
        String task2 = "Отложить будильник";
        String task3 = "Лечь спать";
        String expected = "Лечь спать Отложить будильник Проснуться";
        // В соответствии с алфавитным порядком

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);
        String result = todos.getAllTasks();

        assertThat(result, equalTo(expected));
    }

    @Test
    public void testRemove() {
        Todos todos = new Todos();
        String task1 = "Проснуться";
        String task2 = "Отложить будильник";
        String task3 = "Лечь спать";
        String expected = "Проснуться";

        todos.addTask(task1);
        todos.addTask(task2);
        todos.addTask(task3);
        todos.removeTask(task2);
        todos.removeTask(task3);
        String result = todos.getAllTasks();

        assertThat(result, equalTo(expected));
    }


}
