package com.wsj.arithmetic;

/**
 * @Author: wushijian
 * @Date: 2020/7/23 15:42
 *
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class L88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int size = m + n - 1;
        while (i>=0 && j>=0){
            if(nums1[i] >= nums2[j]){
                nums1[size--] = nums1[i--];
            }else{
                nums1[size--] = nums2[j--];
            }
        }
        // 最后如果nums2有剩余，按顺序放入nums1的头部。
        while(j>=0){
            nums1[j] = nums2[j--];
        }

    }
}
