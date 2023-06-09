package implementation;

import infrastructure.IQuery;
import domaine.model.TypeArgument;


public class Query implements IQuery {
    private String[] query;

    public Query(String[] query) {
        this.query = query;
    }

    public String[] getQuery() {
        return this.query;
    }

}
