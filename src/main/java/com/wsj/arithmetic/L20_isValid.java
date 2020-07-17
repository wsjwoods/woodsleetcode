package com.wsj.arithmetic;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: wushijian
 * @Date: 2020/7/16 17:59
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L20_isValid {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        try {
            for (char c : s.toCharArray()) {
                Character left = mappings.get(c);
                if (left == null) {
                    stack.push(c);
                } else {
                    Character leftC = stack.pop();
                    if (left != leftC) return false;
                }
            }
        }catch (ArrayIndexOutOfBoundsException | EmptyStackException e){
            return false;
        }
        return stack.isEmpty();
    }
}
