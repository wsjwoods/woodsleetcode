package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/22 17:25
 *
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class L69_mySqrt {
    public int mySqrt(int x) {
        if(x == 1) return x;
        int left = 0;
        int right = x;

        while ( (right - left) > 1){
            int mid = ( (right - left) >> 1 ) + left;
            long square = (long)mid * mid;
            if(square == x){
                return mid;
            }else if(square < 0 || square > x){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return left;
    }
}
