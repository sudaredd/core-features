package com.jp;

public class ChunkedPalindrom {

    public static void main(String[] args) {
        int num = numOfChunkedPalindroms("teammate");
        System.out.println(num);

        num = numOfChunkedPalindroms("abca");
        System.out.println(num);
    }

    private static int numOfChunkedPalindroms(String text) {
        int left = 0;
        int right = text.length() - 1;
        int lastLeft = left;
        int lastRight = right;
        int total = 0;
        boolean lastMatch = false;
        while (left <= right) {
            lastMatch = false;
            if (isSame(text.substring(lastLeft, left + 1), text.substring(right, lastRight + 1))) {
                lastLeft = left + 1;
                lastRight = right - 1;
                total += 2;
                lastMatch = true;
            }
            left++;
            right--;
        }
        return lastMatch ? total : total + 1;


    }

    private static boolean isSame(String text1, String text2) {

        return text1.equals(text2);
    }
}
