package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/23 11:00
 *
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class L70_climbStairs {
    public int climbStairs(int n) {
        int f1 = 1,f2 = 1,res = 1;
        for(int i=0;i<n - 1;i++){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
