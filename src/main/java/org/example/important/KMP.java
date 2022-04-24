package org.example.important;

/**
 * 字符串匹配终极算法
 */
public class KMP {

    public static void main(String[] args) {
        char[] str = "hello".toCharArray();
        char[] pattern = "ll".toCharArray();
        int[] next = new int[pattern.length];
        KMP kmp = new KMP();
        kmp.getNext(pattern,next);
        System.out.printf(String.valueOf(next));
    }

    public int search(char[] str,char[] pattern,int[] next){
        int i=0;
        int j=0;
        while(i<str.length && j<pattern.length){
            if(j == -1 || str[i] == pattern[j]){
                i++;j++;
            }else{
                j = next[j];
            }
        }
        if(j==pattern.length){
            return i-j;
        }else{
            return -1;
        }
    }

    public void getNext(char[] pattern,int[] next){
        next[0] = -1;
        int i = 0;
        int j=-1;
        while( i < pattern.length-1){
            if(j==-1){
                i++;j++;
            }else if(pattern[i]==pattern[j]){
                i++;j++;
                next[i] = j;
            }else{
                j = next[i];
            }
        }
    }

//    public int search(char[] str, char[] pattern, int[] next) {
//        int i = 0;
//        int j = 0;
//        while (i < str.length && j < pattern.length) {
//            if (j == -1 || str[i] == pattern[j]) {
//                i++;
//                j++;
//            } else {
//                j = next[j];
//            }
//        }
//        if (j == pattern.length) {
//            return i - j;
//        } else {
//            return -1;
//        }
//    }
//
//
//    public void getNext(char[] pattern, int[] next) {
//        next[0] = -1;
//        int i = 0, j = -1;
//        while (i < pattern.length-1) {
//            if (j == -1) {
//                i++;
//                j++;
//            } else if (pattern[i] == pattern[j]) {
//                i++;j++;
//                next[i] = j;
//            } else {
//                j = next[i];
//            }
//        }
//    }
}
