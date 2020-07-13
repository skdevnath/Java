package score.test.com;

import java.util.Iterator;
import java.util.TreeMap;

public class RankEntry {
    final int rank;
    TreeMap<String, String> teams = new TreeMap();

    public RankEntry(int score) {
        this.rank = score;
    }

    public String removeTeam(Team team) {
        String teamName = this.teams.remove(team.name.toLowerCase());
        return teamName;
    }

    public void addTeam(Team team) {
        this.teams.put(team.name.toLowerCase(), team.name);
    }

    // Returns Team's name (case sensitive in ascending order)
    public Iterator<String> getTeamsName() {
        Iterator<String> ret = this.teams.values().iterator();
        return ret;
    }
}
