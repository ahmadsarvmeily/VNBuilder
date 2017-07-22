import java.io.File;

abstract class EngineTest {

    static void dirExists(String dirName) {
        File dir = new File(dirName);
        String dirFoundMessage = "Found "+dirName+" directory";
        String dirFoundSuccess = dir.isDirectory() ? "[SUCCESS]" : "[FAILURE]";
        System.out.println(dirFoundSuccess +"\t"+ dirFoundMessage);
    }

    static void fileExists(String fileName) {
        File file = new File(fileName);
        String fileFoundMessage = "Found "+fileName+" file";
        String fileFoundSuccess = file.isFile() ? "[SUCCESS]" : "[FAILURE]";
        System.out.println(fileFoundSuccess +"\t"+ fileFoundMessage);
    }
}
