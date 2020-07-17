package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/6/23 14:12
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L67_AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuilder builder = new StringBuilder();
        int temp = 0;
        int a1 ;
        int b1 ;
        while (index1 >= 0 || index2 >= 0){
            //a上的字符
            a1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;

            //b上的字符
            b1 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;

            //a1 ^ b1 ^ temp 求出当前位置的结果，逢2进1
            builder.append(a1 ^ b1 ^ temp);

            //进位
            temp = (a1 + b1 + temp) >> 1;
        }
        if(temp > 0){
            builder.append(temp);
        }
        return builder.reverse().toString();
    }




}

