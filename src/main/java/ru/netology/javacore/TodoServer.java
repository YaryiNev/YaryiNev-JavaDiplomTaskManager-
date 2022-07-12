package ru.netology.javacore;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos taskList) {
        this.port = port;
        this.todos = taskList;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    final String json = in.readLine();
                    ObjectMapper objectMapper = new ObjectMapper();
                    MsgBuilder msgBuilder = objectMapper.readValue(json, MsgBuilder.class);

                    if (msgBuilder.getType().equals("ADD")) {
                        todos.addTask((msgBuilder.getTask()));
                    } else if (msgBuilder.getType().equals("REMOVE")) {
                        todos.removeTask(msgBuilder.getTask());
                    }

                    out.println(todos.getAllTasks());

                } catch (IOException e) {
                    System.out.println("Не могу стартовать сервер");
                    e.printStackTrace();
                }
            }
        }
    }
}
