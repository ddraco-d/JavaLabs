package com.company.Lab17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static PrintWriter pw;
    static void getInfo(String path) {
        File file = new File(path);
        if(file.isDirectory()){
            String[] contents = file.list();
            for (String s:contents) {
                getInfo(path + "/" +s);
            }
        }
        if(file.isFile() ) {
            if (file.getName().endsWith(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    pw.write("##### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        pw.write(line + "\n");
                        line = reader.readLine();
                    }
                    pw.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) {
        Path filePath = Paths.get("").toAbsolutePath();
        try {
            pw = new PrintWriter("AllWorks.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getInfo(filePath.toString()+"/src");
        pw.close();
    }

}
