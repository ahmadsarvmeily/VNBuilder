package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Novel {

    private File file;
    private String title;
    private Queue<String> lines;

    Novel(String fileName) {
        file = new File(fileName);
        lines = new LinkedList<>();
        load();
    }

    private void load() {
        try {
            Scanner novelScanner = new Scanner(file);

            while(novelScanner.hasNextLine()) {
                String line = novelScanner.nextLine();
                String[] lineArr = line.split("\\|");

                switch (lineArr[0]) {
                    case "title": title = lineArr[1];
                        break;
                    //Other non-story related info goes here

                    default: lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    boolean hasLines() {
        return !lines.isEmpty();
    }

    String nextLine() {
        return lines.remove();
    }

    String getTitle() {
        return title;
    }
}
