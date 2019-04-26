package com.wsj.arithmetic;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-12321));
        System.out.println(isPalindrome2(21120));
    }

    public static boolean isPalindrome(int x) {
        boolean flag = false;
        StringBuffer str = new StringBuffer().append(x);
        if(str.toString().equals(str.reverse().toString())) flag=true;
        return flag;
    }

    /**
     * 不转换成字符串处理
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if(x>=0 && x<10 ) return true; //x=个位数   true
        if(x<0  || x%10==0) return false; //x<0  或者 x的结尾是0  false
        int tmp = 0; //临时值
        int revert = 0;//保存反转值

        //设 x = 12321
        while (x>revert){
            tmp = x%10; //tmp = x的个位数  tmp = 1 , 2 , 3
            x = x/10; //x = x去掉末位  x = 1232 , 123 , 12
            if(x==revert) return true;  // 1232!=0 , 123!= 1 , 12==12
            revert = revert*10;  //revert = 保存的反转值加上1位   0 , 10
            revert += tmp; //revert再加上tmp  1 , 12
            if(x==revert) return true;
        }
        return false;
    }
}
