/*
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (26.61%)
 * Total Accepted:    97.3K
 * Total Submissions: 365.8K
 * Testcase Example:  '[1]\n0'
 *
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 *
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 *
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 *
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public int min = Integer.MAX_VALUE;
    public void dfs(int[] coins, int amount, int now, int count) {
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        if (now < 0 || amount < 0 || count > min)
            return;
        for (int freq = amount / coins[now]; freq >= 0; freq--) {
            if (count + freq > min)
                break;
            dfs(coins, amount - coins[now] * freq, now - 1, count + freq);
        }
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
