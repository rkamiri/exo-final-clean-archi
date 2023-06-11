import implementation.QueryHandler;
import implementation.QueryTaskDispatcher;

public class Main {
    public static void main(String[] args) {

        new QueryHandler(new QueryTaskDispatcher()).handle(args);
    }
}
