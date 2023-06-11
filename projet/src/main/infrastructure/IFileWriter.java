package infrastructure;

import java.io.IOException;

public interface IFileWriter {
    public void write(String path, String content) throws IOException;
}
