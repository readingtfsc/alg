package com.moogflow.alg.string;


public class Str {
    public static void main(String[] args) {
        String s1 = "Hello World";
        char[] chars = s1.toCharArray();
        chars[5] = ',';

        String string = new String(chars);
        System.out.println(string);


        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();

        buffer.append(1);
        System.out.println(buffer);
        builder.append(1);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
