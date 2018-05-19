/*
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (42.15%)
 * Total Accepted:    61.8K
 * Total Submissions: 146.7K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the
 * following restrictions:
 *
 *
 * ⁠   You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * ⁠   After you sell your stock, you cannot buy stock on next day. (ie,
 * cooldown 1 day)
 *
 *
 * Example:
 *
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 *
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int L = prices.length;
        if (L < 2)
            return 0;
        int has1_doNothing = -prices[0];
        int has1_Sell = 0;
        int has0_doNothing = 0;
        int has0_Buy = -prices[0];
        for (int i = 1; i < L; i++) {
            has1_doNothing = has1_doNothing > has0_Buy ? has1_doNothing : has0_Buy;
            has0_Buy = -prices[i] + has0_doNothing;
            has0_doNothing = has0_doNothing > has1_Sell ? has0_doNothing : has1_Sell;
            has1_Sell = prices[i] + has1_doNothing;
        }
        return has1_Sell > has0_doNothing ? has1_Sell : has0_doNothing;
    }
}
