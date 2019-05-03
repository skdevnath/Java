package com.sandip.AllListEg;
import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
    ArrayList<String> myArrayList = new ArrayList<String>();
    public TestArrayList() {
        myArrayList.add("Sandip");
        myArrayList.add("Raj");
        myArrayList.add(4, "Kumar"); /* Add element at 4th position */
    }

    public void test() {
        /* Print all elements */
        Iterator<String> itr = myArrayList.iterator();
        while (itr.hasNext()) {
            System.out.println(" " + itr.next());
        }
        /* print the capacity and size */
        /* Add one element beyond the current size, say at 8th position */
        /* Now print the capacity, and size */
        /* Iterate through the list and print all */
    }
}
