package me.keepup.neo.wx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    static Pattern p=Pattern.compile(" ");

    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(String string, int length) {
        // write your code here
        Matcher m = p.matcher(string);
        int i=0;
        while(m.find()){
            i++;
        }
        string = string.replaceAll(" ","%20");
        System.out.println(string);
        return length+i*2;
    }


    public static void main(String[] args) {
        int o = replaceBlank("hello world",11);
        System.out.println(o);
    }
}