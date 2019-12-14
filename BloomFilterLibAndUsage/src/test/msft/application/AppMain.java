package test.msft.application;

import test.msft.bloomfilter.BfException;
import test.msft.bloomfilter.BloomFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AppMain {

    // Enable logger
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static{
        try {
            logManager.readConfiguration(new FileInputStream("./logger.properties"));
        } catch (IOException exception) {
            logger.severe("Error in loading configuration: " + exception);
        }
    }


    public static void main(String args[]) {
        logger.info("Initializing Bloofilter for word dictionary");

        // Test case 1:
        // To test extreme condition, I set filterSz to 1, with this if a word doesn't exist,
        // we still get false positive result i.e. query respond saying that element exists.
        // This is expected as only one bit to play with.
        //BloomFilter wordBfDB = new BloomFilter(logger, (1 << 1) - 1, 4);
        // Above check hash index's hitting the boundary bits in BloomFilter,
        // it checks, if there is no out of range array access.

        // Test case 2:
        // Another extreme condition: I set filterSz to 3, it is also similar to above.
        //BloomFilter wordBfDB = new BloomFilter(logger, (1 << 2) - 1, 4);
        // Above check hash index's hitting the boundary elements, there is no out of
        // range array access.

        // Test case 3:
        // Let's try use max number of indexes i.e. 8
        BloomFilter wordBfDB = new BloomFilter(logger, (1 << 16) - 1, 8);

        // Add few test words to our dictionary
        String[] myTestWords = {"test", "this", "program"};
        logger.info("ADDING these words to dictionary:");
        for(String word: myTestWords) {
            logger.fine(String.format(" Adding word: \"%s\"", word));
            try {
                wordBfDB.setValue(word);
            } catch (BfException ex) {
                logger.severe("Error in adding words:" + ex);
            }
        }

        // Check if words are in our dictionary, there can be false position as it based on Bloomfilter.
        logger.info("CHECKING these words in our dictionary:");
        for(String word: myTestWords) {
            logger.fine(String.format("Checking word: \"%s\"", word));
            try {
                if (wordBfDB.checkValueIfExists(word)) {
                    logger.fine(" Found in our dictionary..PASSED.");
                } else {
                    logger.fine(" Not able to find in our dictionary..FAILED..");
                }
            } catch (BfException ex) {
                logger.severe("Error during checking work:" + ex);
            }
        }

        // Check few non existing works, we should see 100% lookup failure for those.
        String[] nonExistingWords = {"bloomfilter", "is", "great"};
        logger.info("CHECKING these non-existing words in our dictionary:");
        for(String word: nonExistingWords) {
            logger.fine(String.format("Checking word: \"%s\"", word));
            try {
                if (wordBfDB.checkValueIfExists(word)) {
                    logger.fine(" Found in our dictionary..FAILED...");
                } else {
                    logger.fine(" Not able to find in our dictionary.PASSED..");
                }
            } catch (BfException ex) {
                logger.severe("Error during checking work:" + ex);
            }
        }
    }
}
