package com.why.javaassitst;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilderDemo inst = new StringBuilderDemo();
        for (int i = 0; i < args.length; i++) {
            String result = inst.buildString(Integer.parseInt(args[i]));
            System.out.println("Constructed string of length " +
                    result.length());
        }
    }

    private String buildString$impl(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += (char)(i%26 + 'a');
        }
        return result;
    }
    private String buildString(int length) {
        long start = System.currentTimeMillis();
        String result = buildString$impl(length);
        System.out.println("Call to buildString took " +
                (System.currentTimeMillis()-start) + " ms.");
        return result;
    }

}
