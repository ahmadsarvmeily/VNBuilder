package main;

import phrases.Phrase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Novel {

    private File file;
    private String title;
    private Queue<String> lines;
    private boolean pauseExecution;

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

    void advance() {
        pauseExecution = false;
        while(hasLines() && !pauseExecution) {
            String line = nextLine();
            Phrase nextPhrase = Phrase.createPhrase(line);
            if(nextPhrase != null) {
                nextPhrase.execute();
            }
        }
    }

    private boolean hasLines() {
        return !lines.isEmpty();
    }

    private String nextLine() {
        return lines.remove();
    }

    String getTitle() {
        return title;
    }

    void pauseExecution() {
        pauseExecution = true;
    }
}
