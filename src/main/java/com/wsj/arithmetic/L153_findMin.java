package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/22 14:14
 *
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class L153_findMin {
    public int findMin(int[] nums) {
        // 二分法
        int left = 0;
        int right = nums.length - 1;
        int leftNum = nums[left];
        int rightNum = nums[right];
        if(leftNum < rightNum) return leftNum;
        while ((right - left) > 1 ){
            int mid = ( (right - left) >> 1 ) + left ;
            int midNum = nums[mid];
            if(midNum > leftNum){
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums[right];

    }
}
