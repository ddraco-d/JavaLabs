package com.company.Lab21_22;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ServerJson implements ItemsStore {
    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new Gson();
    private String URL = "http://localhost:3000/posts";//любой http сервер Json


    @Override
    public List<Item> getAll() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Item> itemList = gson.fromJson(response.body(), List.class);
        for (int i = 0; i < itemList.size(); i++)
        {
            Item item = (gson.fromJson(String.valueOf(itemList.get(i)),Item.class));
            System.out.println(item.toString1());
        }
        return itemList;
    }

    @Override
    public Item get(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL+"/"+id))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public Item addItem(Item item) {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(URL))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response.body(),Item.class);
    }

    @Override
    public Item editItem(Item item) {
        int id = item.getId();
        System.out.println(gson.toJson(item));
        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(item)))
                .uri(URI.create(URL+"/" + id))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void deleteItem(Item item) {
        int id = item.getId();
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(URL+"/"+id))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
