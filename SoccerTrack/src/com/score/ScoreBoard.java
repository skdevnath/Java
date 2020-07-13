package com.score;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class ScoreBoard {
    HashMap<String, Team> teamDb = new HashMap<>();
    TreeMap<Integer, RankEntry> rankDb = new TreeMap(Collections.reverseOrder());

    private void updateTeam(String teamName, int point) {
        Team team;
        if (teamDb.containsKey(teamName)) {
            team = teamDb.get(teamName);
            // If team is in teamDb, then we expect it's rank tobe 100% in rankDb too
            RankEntry rankEntry = rankDb.get(team.getPoint());
            rankEntry.teams.remove(teamName.toLowerCase());
            if (rankEntry.teams.isEmpty()) {
                rankDb.remove(team.getPoint());
            }

            team.updatePoint(point);
            // Update the team with new rank entry
            int newPoint = team.getPoint();
            updateRank(teamName, newPoint);
        } else  {
            team = new Team(teamName, point);
            updateRank(teamName, point);
        }
        teamDb.put(teamName, team);
    }

    private void updateRank(String teamName, int rank) {
        if (rankDb.containsKey(rank)) {
            // Add the team, if doesn't exist
            RankEntry rankEntry = rankDb.get(rank);
            rankEntry.teams.put(teamName.toLowerCase(), teamName);
        } else {
            RankEntry rankEntry = new RankEntry(rank);
            rankEntry.teams.put(teamName.toLowerCase(), teamName);
            rankDb.put(rank, rankEntry);
        }
    }

    public void processMatchEntry(String matchEntry) {
        if (matchEntry == null || matchEntry.length() == 0) {
            return;
        }
        String[] teamScoreStr = matchEntry.split(",");
        String pattern = "(\\s*)(\\w+[\\s\\w]*)(\\s+)(\\d+)";
        if (teamScoreStr.length == 2) {
            //Sandip:
            //System.out.println("Team 1: " + teamScoreStr[0]);
            //System.out.println("Team 2: " + teamScoreStr[1]);

            String team1Name = teamScoreStr[0].replaceAll(pattern, "$2");
            String team1ScoreStr = teamScoreStr[0].replaceAll(pattern, "$4");
            String team2Name = teamScoreStr[1].replaceAll(pattern, "$2");
            String team2ScoreStr = teamScoreStr[1].replaceAll(pattern, "$4");

            int team1Score =  Integer.parseInt(team1ScoreStr); // Assuming data is right i.e. it is pure digit
            int team2Score =  Integer.parseInt(team2ScoreStr); // Assuming data is right i.e. it is pure digit

            if (team1Score > team2Score) {
                updateTeam(team1Name, WIN_POINT);
                updateTeam(team2Name, LOST_POINT);
            } else if (team1Score == team2Score) {
                updateTeam(team1Name, TIE_POINT);
                updateTeam(team2Name, TIE_POINT);
            } else {
                updateTeam(team2Name, WIN_POINT);
                updateTeam(team1Name, LOST_POINT);
            }
        }
    }

    public static int WIN_POINT = 3;
    public static int TIE_POINT = 1;
    public static int LOST_POINT = 0;
}
