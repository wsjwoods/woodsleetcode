package com.wsj.arithmetic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wushijian
 * @date 2020/8/5 16:25
 *
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class L22_generateParenthesis {

    @Test
    public void test() {
        generateParenthesis(5);
    }

    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>();
        List<String> empty = new ArrayList<>();
        empty.add("");
        dp.add(0,empty);
        for(int i=1;i<=n;i++){
            List<String> tmp = new ArrayList<>();
            for(int j=0;j<i;j++){
                List<String> dp1 = dp.get(j);
                List<String> dp2 = dp.get(i-j-1);
                for(int x=0;x<dp1.size();x++)
                    for (int y = 0; y < dp2.size(); y++) {
                        String str = "(" + dp1.get(x) + ")" + dp2.get(y);
                        tmp.add(str);
                    }

            }
            dp.add(i,tmp);
            System.out.println(dp.get(i));
        }

        return dp.get(n);
    }
}
