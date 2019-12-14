Here is the project files. I added logger too so that field debugging becomes easy. I have whole Bloom Filter code under "bloomfilter" package and I used that under AppMain.java. Where I have different cases like.
1. Test extreme/boundary cases like have only 1,2 bit BF. Those are commented out after test, I can convert them to junit tests.
2. Create BF for word dictionary
3. Add words
4. Check if those words search successfully or not
5. Check words, which never inserted into dictionary and all those should fail (100% time).

Project directory structure is following. You can import in Eclips or intelliJ IDE.
.

├── BloomFilterLibAndUsage.iml
├── log.0.0.txt
├── logger.properties
└── src
    └── test
        └── msft
            ├── application
            │   └── AppMain.java
            └── bloomfilter
                ├── BfException.java
                └── BloomFilter.java


Let me know if you have any questions/comment.
