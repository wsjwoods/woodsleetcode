package com.wsj.arithmetic;

import org.junit.Test;

/**
 * @Author: wushijian
 * @Date: 2020/7/2 11:34
 *
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L378_KthSmallest {

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix,k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n-1][n-1];
        while (low <= high){
            int midVal = low + ((high - low) >>> 1); // 获取中间值 相当于 low + (high - low)/2
            int rank = getRankInMatrix(matrix,midVal); // 矩阵中小于等于它的个数
            if (rank < k){
                low = midVal + 1;
            }else{
                high = midVal - 1;
            }
        }
        return low;
    }

    public int getRankInMatrix(int[][] matrix, int midVal) {
        int n = matrix.length;
        int rank = 0, row = 0, col = n - 1;
        while (row < n && col >=0){
            if(midVal >= matrix[row][col]){ // 大于等于当前行的最大值
                rank += col + 1; // 大于了col个数，排名加 col+1
                row ++ ; // 然后比较下一行
            } else { // 小于当前行的最大值
                col--; // 留在当前行继续比较
            }
        }
        return rank;
    }
}
