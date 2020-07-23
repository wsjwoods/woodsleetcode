package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/22 14:06
 *
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 *
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 *
 */
public class L154_findMin {
    public int findMin(int[] nums) {
        int tmp = nums[0];
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num<tmp){
                return num;
            }else{
                tmp = num;
            }
        }
        return nums[0];
    }

    // 二分法，可重复
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int leftNum = nums[left];
        int rightNum = nums[right];
        if(leftNum < rightNum) return leftNum;
        while ((right - left) > 1 ){
            int mid = ( (right - left) >> 1 ) + left ;
            int midNum = nums[mid];
            if(midNum == leftNum){
                left++;
                if(nums[left] < nums[right]) return nums[left];
            }
            else if(midNum > leftNum){
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums[right];
    }
}
