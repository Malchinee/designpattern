package top.malchinee.algorithm.impl;

import top.malchinee.Context;
import top.malchinee.algorithm.SortAlgorithm;

public class BidirBubbleSort implements SortAlgorithm {

    public int[] sort(int[] nums) {
        int j;
        int limit = nums.length;
        int st = -1;
        while (st < limit) {
            boolean flipped = false;
            st++;
            limit--;
            for (j = st; j < limit; j++) {
                if (nums[j] > nums[j + 1]) {
                    int T = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = T;
                    flipped = true;
                }
            }
            if (!flipped) {
                return nums;
            }
            for (j = limit; --j >= st; ) {
                if (nums[j] > nums[j + 1]) {
                    int T = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = T;
                    flipped = true;
                }
            }
            if (!flipped) {
                return nums;
            }
        }

        return nums;
    }

    @Override
    public int[] sort(int[] nums, Context ct) {
        ct.startExecution();
        int[] sortArr = sort(nums);
        ct.endExecution();
        return sortArr;
    }
}
