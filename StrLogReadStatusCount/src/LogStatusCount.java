//    You have an web server access log.  An example line from the file is:
//
//            192.168.1.101 - jason [10/Oct/2010:11:55:36 -0600] "GET /gg.gif HTTP/1.0" 200 232612312
//
//    The second to last field in each line is the HTTP response status code.  Using
//    any language you like, write a script to count the number of occurrences of each
//    status code.  The output should look something like:
//
//            200 1211
//            503 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.sun.deploy.util.StringUtils;

public class LogStatusCount {

    int getStatus(String logLine) {
        String status = "";
        if (logLine != null && logLine.length() > 0) {
            boolean lastDigitFound = false;
            boolean lastDigitStart = false;

            boolean statusFound = false;
            boolean statusStart = false;
            LinkedList<Character>  statusChListRev = new LinkedList<>();
            for (int i = logLine.length() - 1; i >= 0; i--) {
                boolean isDigit = (logLine.charAt(i) >= '0' && logLine.charAt(i) <= '9');
                if (!lastDigitFound) {
                    if (!lastDigitStart && isDigit) {
                        lastDigitStart = true;
                    }
                    if (lastDigitStart) {
                        if (!isDigit) {
                            lastDigitFound = true;
                        }
                    }
                } else {
                    if (!statusFound) {
                        if (!statusStart && isDigit) {
                            statusStart = true;
                        }
                        if (statusStart) {
                            if (!isDigit) {
                                statusFound = true;
                                break;
                            } else {
                                statusChListRev.add(logLine.charAt(i));
                                System.out.println("Adding " + "'" + logLine.charAt(i) + "'");
                            }
                        }
                    }
                }
            }
            if (statusFound) {
                StringBuffer  statusStrBuffer = new StringBuffer();
                Iterator<Character> x = statusChListRev.descendingIterator();
                while (x.hasNext()) {
                    statusStrBuffer.append(x.next());
                }
                status = statusStrBuffer.toString();
                System.out.printf("Status: %s%n", status);
            }
        }
        return Integer.parseInt(status);
    }

    public static void main(String[] args) {
        LogStatusCount logStatusCount = new LogStatusCount();
        try {
            System.out.println("Current Dir " + System.getProperty("user.dir"));
            FileReader fileReader = new FileReader("../StrLogReadStatusCoutnt/src/test.log");
            BufferedReader  bufferedReader = new BufferedReader(fileReader);
            String line;
            HashMap<Integer, Integer> statusCount = new HashMap<Integer, Integer>();

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Input log line: " + line);
                int status = logStatusCount.getStatus(line);
                if (statusCount.containsKey(status)) {
                    statusCount.put(status, statusCount.get(status) + 1);
                } else {
                    statusCount.put(status, 1);
                }
            }
            statusCount.forEach((k, v) -> System.out.printf("%d -> %d\n", k, v));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    };
}
