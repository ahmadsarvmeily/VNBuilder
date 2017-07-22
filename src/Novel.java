import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Novel {

    private File file;
    private String title;

    Novel(String fileName) {
        file = new File(fileName);
        load();
    }

    private void load() {
        try {
            Scanner novelScanner = new Scanner(file);

            while(novelScanner.hasNextLine()) {
                String line = novelScanner.nextLine();
                String[] lineArr = line.split(" ");

                switch (lineArr[0]) {
                    case "title": title = lineArr[1];
                        break;
                    //TODO: More keywords
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    String getTitle() {
        return title;
    }
}
