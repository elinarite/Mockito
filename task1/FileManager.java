package mockito.task1;

public class FileManager {
    private FileReader fileReader;

    public FileManager() {
    }

    public FileManager(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public String createText(String filePath) {
        return fileReader.readFile(filePath);
    }
}