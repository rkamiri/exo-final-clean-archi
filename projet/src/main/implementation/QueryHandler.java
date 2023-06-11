package implementation;

import infrastructure.IQuery;
import infrastructure.IQueryHandler;
import infrastructure.IQueryTaskDispatcher;

public class QueryHandler implements IQueryHandler {
    private IQueryTaskDispatcher queryTaskDispatcher;
    public QueryHandler(IQueryTaskDispatcher queryTaskDispatcher) {
        this.queryTaskDispatcher = queryTaskDispatcher;
    }

    @Override
    public void handle(String[] query) {
        IQuery queryToSend = new SystemQuery(query);
        this.queryTaskDispatcher.dispatch(queryToSend);
    }
}
