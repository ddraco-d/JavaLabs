package com.company.Lab21_22;

public class Item {
    private int id;
    private String data;
    private boolean flag;
    private String description;

    public Item(int id, String data, boolean flag, String description) {
        this.id = id;
        this.data = data;
        this.flag = flag;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{\n" +
                "id=" + id +
                ", \ndata='" + data + '\'' +
                ", \nflag=" + flag +
                ", \ndescription='" + description + '\'' +
                "\n}";
    }

    public String toString1()
    {
        return "Item{\n" +
                "id=" + id +
                ", \ndata='" + data + '\'' +
                ", \nflag=" + flag +
                "\n}";
    }

    public String toString2()
    {
        return "   {\n" +
                "      \"id\": " + id + "," +
                "\n    \"data\": " + "\"" + data +"\"" + "," +
                "\n    \"flag\": " + flag + "," +
                "\n    \"description\": " + "\"" + description + "\"" +
                "\n   }";
    }
}
