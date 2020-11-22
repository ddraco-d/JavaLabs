package com.company.Lab21_22;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemsStore itemStore = null;
        Scanner in = new Scanner(System.in);
        System.out.println("1-Server\n2-Local");
        int choose;
        choose = in.nextInt();
        if(choose == 1){
            itemStore = new ServerJson();
        } else if (choose == 2) {
            itemStore = new LocalWork();
        }
        System.out.println("1-get all\n2-get\n3-add\n4-edit\n5-delete");
        int pas;
        while (true){
            pas = in.nextInt();
            switch (pas){
                case 1:
                    List<Item> items = itemStore.getAll();
                    try {
                        for (int i = 0; i < items.size(); i++) {
                            if (choose == 2)
                                System.out.println(items.get(i).toString1());
                        }
                    } catch (Exception ex) {
                        System.out.println("Список пуст(");
                    }
                    break;
                case 2:
                    System.out.print("Enter Item id: ");
                    int IdSearch = in.nextInt();
                    Item Items = itemStore.get(IdSearch);
                    if (Items == null) {
                        System.out.println("Error");
                    } else {
                        System.out.println(Items.toString());
                    }
                    break;
                case 3:
                    int id;
                    String data, description;
                    boolean flag;
                    System.out.print("Item id:");
                    id = in.nextInt();
                    System.out.print("Item data:");
                    data = in.next();
                    System.out.print("Is flag?");
                    flag = in.nextBoolean();
                    System.out.print("description:");
                    description = in.next();
                    itemStore.addItem(new Item(id, data, flag, description));
                    System.out.println("Item added");
                    break;
                case 4:
                    System.out.print("Enter item id: ");
                    int IdSearch1 = in.nextInt();
                    Item Item_I = itemStore.get(IdSearch1);
                    String newData;
                    boolean Flag;
                    String newDescription;
                    System.out.println(Item_I);
                    System.out.print("Enter new data:");
                    newData = in.next();
                    System.out.print("Is flag?");
                    Flag = in.nextBoolean();
                    System.out.print("Enter new description:");
                    newDescription = in.next();
                    itemStore.editItem(new Item(IdSearch1, newData, Flag, newDescription));
                    System.out.println("Item edited!");
                    break;
                case 5:
                    System.out.print("Enter item id: ");
                    int IdSearch2 = in.nextInt();
                    itemStore.deleteItem(new Item(IdSearch2, "", true, ""));
                    System.out.println("Item deleted!");
                    break;
            }
        }

    }
}