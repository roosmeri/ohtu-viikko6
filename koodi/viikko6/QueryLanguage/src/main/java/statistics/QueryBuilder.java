package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
    }

    Matcher matcher() {
        return matcher;
    }

    QueryBuilder HasFewerThan(int value, String category) {
        this.matcher = new HasFewerThan(value, category);
        return this;
    }

    QueryBuilder HasAtLeast(int value, String category) {
        this.matcher = new HasAtLeast(value, category);
        return this;
    }

    QueryBuilder PlaysIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }

    QueryBuilder OneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    QueryBuilder AllOf(Matcher... matchers) {
        this.matcher = new And(matchers);
        return this;
    }

    QueryBuilder NoneOf(Matcher matcher) {
        this.matcher = new Not(matcher);
        return this;
    }

}
