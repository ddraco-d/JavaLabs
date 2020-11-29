package com.company.Lab23_24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private String surname = "Komarov";
    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String localPath = "src/main/java/com/company/Lab23_24/reports.json";
    private String taskURL = "http://80.87.199.76:3000/tasks";
    private String reportURL = "http://80.87.199.76:3000/reports";
    private List<TaskItem> availableTasks;
    private List<TaskItem> doneTasks = new ArrayList<>();

    private File jsonFile = new File(localPath);

    public Worker() {
        try {
            jsonFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeWork() {
        Random random = new Random();
        long someTime = random.nextInt(2000 - 1000) + 1000;
        while (true) {
            Thread thread = new Thread(this::work);
            thread.start();
            try {
                thread.join();
                Thread.sleep(someTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            someTime = random.nextInt(2000 - 1000) + 1000;
        }
    }

    private void work() {
        availableTasks = getTask();
        for (int i = 0; i < availableTasks.size(); i++) {
            if (!checkTask(availableTasks.get(i))) {
                postReport(new ReportItem(0, availableTasks.get(i).getId(), surname, count(availableTasks.get(i).getExpression())));
                doneTasks.add(availableTasks.get(i));
                saveTasks();
            }
        }
    }

    private double count(String expression) {
        double first, second;
        double result = 0;
        String exp = expression.replace(" ", "");
        Pattern pattern = Pattern.compile("(?<first>[-]*\\d+)(?<operator>[+-/*])(?<second>[-]*\\d+)");
        Matcher matcher = pattern.matcher(exp);
        if (matcher.find()) {
            first = Double.valueOf(matcher.group("first"));
            second = Double.valueOf(matcher.group("second"));
            switch(matcher.group("operator")) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "/":
                    result = first / second;
                    break;
                case "*":
                    result = first * second;
                    break;
                default:
                    break;
            }
            result = (Math.round(result * Math.pow(10,2)) / Math.pow(10,2));
        }
        return result;
    }

    private void postReport(ReportItem report) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(report)))
                .uri(URI.create(reportURL))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkTask(TaskItem task) {
        for (int i = 0; i < doneTasks.size(); i++) {
            if (doneTasks.get(i).getId() == task.getId()) {
                return true;
            }
        }
        return false;
    }

    private void saveTasks() {
        try (PrintWriter writer = new PrintWriter(jsonFile)) {
            writer.write(gson.toJson(doneTasks));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<TaskItem> getTask() {
        Type ItemType = new TypeToken<Collection<TaskItem>>(){}.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(taskURL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<TaskItem> TaskList = gson.fromJson(response.body(), ItemType);
        return TaskList;
    }
}
