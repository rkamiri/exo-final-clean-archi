package implementation;

import infrastructure.IQuery;
import infrastructure.IQueryTaskDispatcher;

public class QueryTaskDispatcher implements IQueryTaskDispatcher {
    @Override
    public void dispatch(IQuery query) {
        new CommandeHandler().handle(query);
    }
}
