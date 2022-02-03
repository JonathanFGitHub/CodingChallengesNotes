public class ArrayConcat {
    /*
        Given an integer array nums of length n, you want to create an array ans of length 2n where
        ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
        Specifically, ans is the concatenation of two nums arrays.
        Return the array ans.

        Example 1:
        Input: nums = [1,2,1]
        Output: [1,2,1,1,2,1]

        Example 2:
        Input: nums = [1,3,2,1]
        Output: [1,3,2,1,1,3,2,1]

    * */

    public static void main(String[] args) {
        ArrayConcat ac = new ArrayConcat();

        int[] testArray = new int[] {1,2,1};
        ac.getConcatenation(testArray);
    }

    private int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];

        for(int i = 0; i < result.length; i++) {
            int indextwo = i;
            if(i >= nums.length) {
                indextwo = i - nums.length;
            }
            result[i] = nums[indextwo];
        }

        return result;
    }

    // Preferred Solution
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] arr = new int[2 * (nums.length)];

            //[1,2,3]
            // [1, 2, 3, 1, 2, 3]
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
                arr[nums.length + i] = nums[i];
            }
            return arr;

        }
    }
}
