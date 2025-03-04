// Beautiful arrangement 
/*
Time Complexity (TC):
O(k) where k is the number of ans available
or 
O(N!) (Factorial) → The algorithm generates all valid permutations while pruning invalid ones. In the worst case, it tries N! permutations.

Space Complexity (SC):
O(N) → The recursive call stack has at most N levels, and the nums array stores N elements.
 */


class Solution {
    int result; // To store the count of valid arrangements

    public int countArrangement(int n) {
        int[] nums = new int[n + 1]; // Array to track used numbers (1-based index)
        result = 0;
        helper(n, 1, nums); // Start the backtracking process from position 1
        return result;
    }

    private void helper(int n, int position, int[] nums) {
        // If all positions are filled, we found a valid arrangement
        if (position > n) {
            result++; 
            return;
        }

        // Try placing each number from 1 to n in the current position
        for (int i = 1; i <= n; i++) {
            // Check if the number is not used and follows the divisibility condition
            if (nums[i] == 0 && (i % position == 0 || position % i == 0)) {
                nums[i] = position; // Mark the number as used
                helper(n, position + 1, nums); // Recurse to the next position
                nums[i] = 0; // Backtrack and unmark the number
            }
        }
    }
}
