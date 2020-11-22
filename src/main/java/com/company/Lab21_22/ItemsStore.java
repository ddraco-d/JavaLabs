package com.company.Lab21_22;

import java.util.List;

public interface ItemsStore {
    List<Item> getAll();
    Item get(int id);
    Item addItem(Item item);
    Item editItem(Item item);
    void deleteItem(Item item);
}
