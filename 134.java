class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int s = 0; s < gas.length; s++) {
            int needGas = cost[s], nowStaGas = gas[s], nowLeftGas = 0;
            boolean flag = true;
            if (needGas > nowStaGas)
                continue;
            for (int len = 0; len < gas.length; len++) {
                needGas = cost[(s + len) % gas.length];
                nowStaGas = gas[(s + len) % gas.length];
                if (nowLeftGas + nowStaGas < needGas) {
                    flag = false;
                    break;
                }
                nowLeftGas += (nowStaGas - needGas);
            }
            if (flag)
                return s;
        }
        return -1;
    }
}