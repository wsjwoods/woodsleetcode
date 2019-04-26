package com.wsj;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    public int reverse(int x) {
        int res = 0;
        String str = Math.abs(x) + "";
        StringBuffer sb = new StringBuffer();
        for(int i = str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        try {
            res = Integer.valueOf(sb.toString());
        } catch(Exception e)
        {
            return 0;
        }
        return x<0 ? -res : res;
    }
}
