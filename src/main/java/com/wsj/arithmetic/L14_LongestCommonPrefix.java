package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/16 17:13
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String commonPrefix = strs[0];
        StringBuilder tmp = new StringBuilder();
        for(int i=1;i<strs.length;i++){
            String str = strs[i];
            int min = Math.min(commonPrefix.length(),str.length());
            if(min == 0) return "";
            for (int j=0;j<min;j++){
                if(commonPrefix.charAt(j) == str.charAt(j)){
                    tmp.append(str.charAt(j));
                }else{
                    commonPrefix = tmp.toString();
                    tmp = new StringBuilder();
                    break;
                }
                if(j == min - 1) {
                    commonPrefix = tmp.toString();
                    tmp = new StringBuilder();
                }
            }
        }
        return commonPrefix;
    }
}
