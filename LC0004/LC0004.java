package LC0004;

interface SolutionInterface {
    public double findMedianSortedArrays(int[] nums1, int[] nums2);
}
class Solution implements SolutionInterface {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证nums1的长度小于nums2
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // 二分查找
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int mid1 = 0, mid2 = 0;
        while (left <= right) {
            // 二分查找
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            // 边界情况
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
            // 二分查找
            if (nums1LeftMax <= nums2RightMin) {
                mid1 = Math.max(nums1LeftMax, nums2LeftMax);
                mid2 = Math.min(nums1RightMin, nums2RightMin);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        // 返回结果
        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }
}

class MySolution implements SolutionInterface{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }
}

public class LC0004 {
    public static void main(String[] args) {
        testSolution(new Solution());
        testSolution(new MySolution());
    }

    public static void testSolution(SolutionInterface solution) {
        // 测试
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
        // 数据量更大的测试
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums4 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4));
        // 复制情况测试
        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {1, 2, 3, 4, 5};
        System.out.println(solution.findMedianSortedArrays(nums5, nums6));
    }

}
