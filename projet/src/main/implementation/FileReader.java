package implementation;

import infrastructure.IFileReader;

import java.io.File;

public class FileReader implements IFileReader {
    @Override
    public File read(String path) {
        File file = new File(path);
        checkFileExistance(file);
        checkFileIsReadable(file);
        return file;
    }

    private void checkFileExistance(File file){
        if (!file.exists()) {
            throw new IllegalArgumentException("File " + file + " does not exist");
        }
    }

    private void checkFileIsReadable(File file){
        if (!file.canRead()) {
            throw new IllegalArgumentException("File " + file + " cannot be read");
        }
    }
}
