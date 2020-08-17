package com.wsj.arithmetic;

/**
 * @author wushijian
 * @date 2020/8/13 20:15
 *
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class L43_multiply {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n = num1.length(), m = num2.length();
        int[] res = new int[n + m];
        for (int i = n-1; i >=0; i--){
            for (int j = m-1; j >=0; j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int sum = a * b + res[i + j + 1];
                res[i+j] += sum / 10;
                res[i+j+1] = sum % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<res.length;i++){
            if( i == 0 && res[i] == 0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
