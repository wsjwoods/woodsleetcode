package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/27 11:21
 *
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class L392_isSubsequence {

    // 双指针
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while (i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    // 动态规划
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        // 从后往前遍历t
        // f=当前位置[i]及之后第一次出现字符[j]的index,如不存在字符[j]，赋值m。
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<26;j++){
                if(t.charAt(i) == j + 'a'){
                    f[i][j] = i;
                }else{
                    f[i][j] = f[i+1][j];
                }
            }
        }

        int add=0;
        for(int i=0;i<n;i++){
            if(f[add][s.charAt(i) - 'a'] == m){
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;

    }
}
