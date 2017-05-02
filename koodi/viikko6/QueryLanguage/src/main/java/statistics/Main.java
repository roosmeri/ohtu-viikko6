package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();
        Matcher m = query.HasAtLeast(5, "goals")
                .HasAtLeast(10, "assists")
                .HasFewerThan(25, "goals")
                .PlaysIn("PHI")
                .matcher()
        ;

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
