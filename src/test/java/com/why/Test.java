package com.why;

import java.util.Iterator;
import java.util.Properties;

public class Test {


    public static void main(String[] args) {
        Properties props = System.getProperties();
        Iterator iter = props.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println(key + " = " + props.get(key));
        }
    }
}
