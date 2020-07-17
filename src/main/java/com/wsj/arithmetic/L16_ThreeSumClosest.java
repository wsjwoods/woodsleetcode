package com.wsj.arithmetic;

import java.util.*;

/**
 * @Author: wushijian
 * @Date: 2020/6/24 10:16
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L16_ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int x = nums[0];
        int y = nums[1];
        int z = nums[2];

        int xIndex = 0;
        int yIndex = 1;
        int zIndex = 2;
        int max = Math.max(Math.max(x,y),z);
        int min = Math.min(Math.min(x,y),z);
        int offset = 3;
        int sum = x + y + z;
        int diff = target - sum;

        while (true){
            if(diff == 0) {
                break;
            }else if(diff > 0){
                //todo 取三个数中最大的替换后一个比他小的
                for(int i=offset;i<nums.length;i++){
                    if (max > nums[i]){
                        sum = sum - max + nums[i];
                        diff = target - sum;

                    }
                }
            }else {
                //todo  取三个数中最小的替换后一个比他大的
            }
        }


        return sum;

    }
}
