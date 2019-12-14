package test.msft.bloomfilter;

import java.math.BigInteger;
import java.util.BitSet;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BloomFilter {
    BitSet bitSet = new BitSet();
    int filterSize = 0;
    int filterSize2Power = 0;
    int hashIndexes = 0;
    public static int MAX_HASH_INDEXES = 8;
    public static int MAX_FILTER_SIZE = Integer.MAX_VALUE; // TODO: Assuming 2gig bit are enough for now
    Logger logger;

    public BloomFilter(Logger logger, long filterSZ, int hashIndexes) {
        this.logger = logger;
        if (filterSZ > MAX_FILTER_SIZE) {
            throw new IllegalArgumentException("Max filterSZ(" + filterSZ + ") should be " + MAX_FILTER_SIZE + "\n");
        }
        if (filterSZ <= 0) {
            throw new IllegalArgumentException("Filter size can't be 0 or -ve\n");
        }
        if (hashIndexes > MAX_HASH_INDEXES) {
            throw new IllegalArgumentException("Max hash indexes(" + hashIndexes + ") can be " + MAX_HASH_INDEXES + "\n");
        }
        if (hashIndexes <= 0) {
            throw new IllegalArgumentException("Hash indexes can't be 0 or -ve.\n");
        }

        this.hashIndexes = hashIndexes;

        // TODO: Find the nearest 2^x for filterSZ to accomodate. This way
        //      it is easier to get hash indexes by trunking the bit generated
        //      from Digest functions.

        this.filterSize =  1 << filterSize2Power;
        while (this.filterSize <= filterSZ) {
            filterSize2Power++;
            this.filterSize =  1 << filterSize2Power;
        }
        logger.info("Number of bits required: " + filterSize2Power);

        // Now allocate the bloom filter of actual size, all bits will be false initially.
        bitSet = new BitSet(this.filterSize);
    }

    private BigInteger calculateHash(String value) throws NoSuchAlgorithmException  {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return new BigInteger(md.digest(value.getBytes(StandardCharsets.UTF_8)));
    }

    int[] getHashIndexes(String value) throws BfException {
        // Find all hashIndexes indexes
        int hashValue[] = new int[hashIndexes];
        try {
            BigInteger hash = calculateHash(value);
            BigInteger hashRightShifted = hash;
            logger.finest("Computed hash:" + hashRightShifted.toString(16));

            int hashRequiredBits = (1 << filterSize2Power) - 1;
            BigInteger bigIntHashRequiredBits = new BigInteger(Integer.toString(hashRequiredBits));

            for (int i = 0; i < hashIndexes; i++) {
                hashValue[i] = hashRightShifted.and(bigIntHashRequiredBits).intValue();
                hashRightShifted = hashRightShifted.shiftRight(filterSize2Power); // 1 bit is getting wasted, since sha256 has 32 bytes, so issue for now
            }
        }
        catch (NoSuchAlgorithmException ex) {
            logger.severe( "NoSuchAlgo exception: " + ex.getMessage());
            throw new BfException("Internal error");
        }
        return hashValue;
    }

    void logValueNHashIndexes(String value, int[] hashValues, String caller) {
        String hashIdxMsg = "For " + caller + " input: \"" + value + "\", HashIdx:";
        for(int hashIdx: hashValues) {
            hashIdxMsg += hashIdx + ", ";
        }
        logger.finest(hashIdxMsg);
    }

    public void setValue(String value) throws BfException {
        int hashValues[] = getHashIndexes(value);
        // Log value and all hash indexes at DEBUG level, for cornering any bug in BF.
        logValueNHashIndexes(value, hashValues, "SET");

        for(int i = 0; i < hashValues.length; i++) {
           this.bitSet.set(hashValues[i]);
        }
    }

    public boolean checkValueIfExists(String value) throws BfException {
        int hashValues[] = getHashIndexes(value);
        // Log value and all hash indexes at DEBUG level, for cornering any bug in BF.
        logValueNHashIndexes(value, hashValues, "GET");

        boolean exists = true;
        for(int i = 0; i < hashValues.length; i++) {
            if (!this.bitSet.get(hashValues[i])) {
                exists = false;
               break;
            }
        }
        return exists;
    }
}
