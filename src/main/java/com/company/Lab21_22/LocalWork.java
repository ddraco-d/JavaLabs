package com.company.Lab21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LocalWork implements ItemsStore{
    Gson gson = new Gson();
    String path = "/Users/aleksandrkomarov/IdeaProjects/JavaLabs/src/main/java/com/company/Lab21_22/info.json";
    File file = new File(path);
    private FileWriter fileWriter;

    public LocalWork() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        Type type = new TypeToken<List<Item>>() {
        }.getType();
        try (FileReader reader = new FileReader(file)) {
            items = gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item get(int id) {
        List<Item> items = getAll();
        for (Item i : items) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Item addItem(Item item) {
        List<Item> items = getAll();
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);

        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("[\n");
            for (int i = 0; i < items.size(); i++) {
            fileWriter.write(items.get(i).toString2());
            if (i != items.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
            }
            fileWriter.write("]");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item editItem(Item item) {
        int id = item.getId();
        List<Item> Items = getAll();
        try {
            fileWriter = new FileWriter(path);
            for (Item i : Items) {
                if (i.getId() == id) {
                    i.setId(item.getId());
                    i.setData(item.getData());
                    i.setFlag(item.isFlag());
                    i.setDescription(item.getDescription());
                }
            }
            fileWriter.write("[\n");
            for (int i = 0; i < Items.size(); i++) {
                fileWriter.write(Items.get(i).toString2());
                if (i != Items.size() - 1) fileWriter.write(",");
                fileWriter.write("\n");
            }
            fileWriter.write("]");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void deleteItem(Item item) {
        int id = item.getId();
        List<Item> Items = getAll();
        try {
        fileWriter = new FileWriter(path);
        for (int i = 0; i < Items.size(); i++) {
            if (Items.get(i).getId() == id) {
                Items.remove(i);
            }
        }
        fileWriter.write("[\n");
        for (int i = 0; i < Items.size(); i++) {
            fileWriter.write(Items.get(i).toString2());
            if (i != Items.size() - 1) fileWriter.write(",");
            fileWriter.write("\n");
        }
        fileWriter.write("]");
        fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
