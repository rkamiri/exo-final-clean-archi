package implementation;

import infrastructure.IQuery;


public class SystemQuery implements IQuery {
    private String[] query;

    public SystemQuery(String[] query) {
        this.query = query;
    }

    public String[] getQuery() {
        return this.query;
    }

}
