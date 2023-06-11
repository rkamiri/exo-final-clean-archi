package implementation;

import infrastructure.IFileWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter implements IFileWriter {
    @Override
    public void write(String path, String content) throws IOException {
        File file = new File(path);
        createFileIfNotExists(file);

        FileOutputStream outputStream = new FileOutputStream(path);
        byte[] strToBytes = content.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
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
