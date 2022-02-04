import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    /*
     Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        Example 1:

            Input: nums = [1,2,3,1]
            Output: true

        Example 2:

            Input: nums = [1,2,3,4]
            Output: false

        Example 3:

            Input: nums = [1,1,1,3,3,4,3,2,4,2]
            Output: true
     */
    public static void main(String[] args) {

        ContainsDuplicate cd = new ContainsDuplicate();

        System.out.println("1,2,3,1");
        int[] inputArray_ONE = new int[]{1, 2, 3, 1};
        System.out.println(cd.containsDuplicateBRUTE(inputArray_ONE));

        System.out.println("1,2,3,4");
        int[] inputArray_TWO = new int[]{1, 2, 3, 4};
        System.out.println(cd.containsDuplicateBRUTE(inputArray_TWO));

        System.out.println("1,1,1,3,3,4,3,2,4,2");
        int[] inputArray_THREE = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(cd.containsDuplicateBRUTE(inputArray_THREE));
    }

    public boolean containsDuplicateBRUTE(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int peek = i + 1;
            if (peek == nums.length) {
                return false;
            }
            if (nums[i] == nums[peek]) {
                return true;
            }
        }

        return false;
    }

    /*
     * STEPS:
     * 1. Loop Through Array
     * 2. If number at I (iteration point) is contained in the HashSet. return true.
     * 3. ELSE push it to the HashSet.
     * 4. If you never find a duplicate return false at the end.
     * */
    public boolean containsDuplicateBEST(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();

        for(int i : nums) {
            if(numSet.contains(i)) {
                return true;
            }
            else {
                numSet.add(i);
            }
        }

        return false;
    }

    public boolean containsDuplicateJON(int[] nums) {
        HashSet<Integer> numSet = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        if (numSet.size() == nums.length) {
            return false;
        }
        return true;
    }
}