package implementation;

import infrastructure.IOutputLogger;

public class OutputLogger implements IOutputLogger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
