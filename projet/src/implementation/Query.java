package implementation;

import infrastructure.IQuery;
import model.Argument;


public class Query implements IQuery {
    private String[] query;
    private int TaskId;
    private Tuple<Argument,String> argumentData;

    public Query(String[] query) {
        this.query = query;
        this.parseArgumentData();
    }

    public String[] getQuery() {
        return query;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void parseArgumentData() {
        String[] argumentData = this.query[1].split("=");
        this.argumentData = new Tuple<Argument,String>(Argument.valueOf(argumentData[0]), argumentData[1]);
    }
}
