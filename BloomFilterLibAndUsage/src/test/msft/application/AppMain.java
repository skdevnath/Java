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
        BloomFilter wordBfDB = new BloomFilter(logger, (1 << 16) - 1, 4);

        // To test extreme condition, I set filterSz to 1, with this all non existing
        // check test fails. Which is expected as only one bit to play with.
        // BloomFilter wordBfDB = new BloomFilter(logger, (1 << 1) - 1, 4);
        // Above check hash index's hitting the boundary elements, there is no out of range array access.

        // Another extreme condition: I set filterSz to 3, with this few non existing
        // check test passes. Which is expected as atleast 3 bits to play with.
        // BloomFilter wordBfDB = new BloomFilter(logger, (1 << 2) - 1, 4);
        // Above check hash index's hitting the boundary elements, there is no out of range array access.

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
                    logger.fine(" Not able to find in our dictionary..BAD..");
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
                    logger.fine(" Found in our dictionary..BAD...");
                } else {
                    logger.fine(" Not able to find in our dictionary.PASSED..");
                }
            } catch (BfException ex) {
                logger.severe("Error during checking work:" + ex);
            }
        }
    }
}
