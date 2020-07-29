package com.wsj.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wushijian
 * @Date: 2020/7/29 16:16
 *
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class L15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3) return res;

        Arrays.sort(nums);

        int j,k;
        int preI = 0;
        for(int i=0;i<nums.length-2;i++){
            if(i !=0 && preI == nums[i]){ // 如果i等于他后面的数，跳过，继续比较，直到不等为止
                continue;
            }
            preI = nums[i];
            j=i+1;
            k=nums.length-1;
            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    // 如果j等于他后面的数，跳过，继续比较，直到不等为止
                    while(j<nums.length-1){
                        j++;
                        if(nums[j-1] != nums[j]) break;
                    }
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }
}
