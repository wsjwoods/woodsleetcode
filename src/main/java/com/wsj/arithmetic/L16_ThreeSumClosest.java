package com.wsj.arithmetic;

import java.net.Inet4Address;
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

        int j,k;
        int res = nums[0] + nums[1] + nums[2];
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
                int diff = Math.abs(sum - target);
                int resDiff = Math.abs(res - target);
                if(diff < resDiff) res = sum;
                if( sum == target ){
                    return sum;
                }else if(sum > target){
                    k--;
                }else {
                    j++;
                }
            }
        }

        return res;

    }
}
