package com.wsj.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wushijian
 * @Date: 2020/7/27 17:05
 *
 * 6. Z 字形变换
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class L6_convert {

    // 暴力
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        // 列数
        int colNums = s.length() / ( ( numRows - 1 ) * 2 ) * (numRows - 1) + numRows - 1;
        Character[][] charArray = new Character[numRows][colNums];

        int index=0;
        for(int j=0;j<colNums;j++){
            for(int i=0;i<numRows;i++){
                if( (j%(numRows-1) == 0 || (i+j)%(numRows-1) == 0) && index<s.length()){
                    charArray[i][j] = s.charAt(index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<colNums;j++){
                if(charArray[i][j] != null){
                    sb.append(charArray[i][j]);
                }
            }
        }
        return sb.toString();
    }

    //
    public String convert2(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int index = 0;
        int n = 0;
        int flag = 1;
        while (index < s.length()){
            list.get(n).append(s.charAt(index++));
            n += flag;
            if( n == 0 || n == numRows - 1) flag=-flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : list) res.append(row);
        return res.toString();

    }
}
