package com.woods;

import org.junit.Test;

/**
 * @Author: wushijian
 * @Date: 2020/7/17 16:29
 */
public class Test01 {

    @Test
    public void test01(){
        int left=2,right=10;
        int i = ((right - left) >> 1) + left;
        System.out.println(i);
    }

    @Test
    public void test02(){
        int num = 1147395599;
        System.out.println(num * num);


    }
}
