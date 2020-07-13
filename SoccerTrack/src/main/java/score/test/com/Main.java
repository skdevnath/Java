package score.test.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
        if (args.length == 0) {
            System.out.println("Enter file name:");
            Scanner scanner = new Scanner(System.in);
            String inputFile = scanner.next();

            try {
                ScoreBoard   scoreBoard = new ScoreBoard();
                FileReader fileReader = new FileReader("./" + inputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    scoreBoard.processMatchEntry(line);
                }
                int rank = 1;

                for (RankEntry rankEntry: scoreBoard.rankDb.values()) {
                    for (String team: rankEntry.teams.values()) {
                        Team teamEntry = scoreBoard.teamDb.get(team);
                        System.out.println(rank + ". " + team + " " + teamEntry.point);
                    }
                    rank++;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
