package implementation;

import infrastructure.IFileWriter;

import java.io.File;
import java.io.IOException;

public class FileWriter implements IFileWriter {
    @Override
    public void write(String path, String content) {
        File file = new File(path);
        createFileIfNotExists(file);

    }

    private boolean createFileIfNotExists(File file) {
        if (!file.exists()) {
            try{
                return file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
}
