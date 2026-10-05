class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(0, n, memo);
    }

    private int climb(int count, int n, int[] memo) {
        if (count > n) {
            return 0;
        }

        if (count == n) {
            return 1;
        }

        if (memo[count] != 0) return memo[count];
        
        memo[count] = climb(count + 1, n, memo) + climb(count + 2, n, memo);
        return memo[count];
    }
}
