class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder res = new StringBuilder();
        int[] cnt = new int[128];
        boolean[] flag = new boolean[guess.length()];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                flag[i] = true;
                bulls++;
                continue;
            }
            cnt[secret.charAt(i)]++;
        }
        for (int i = 0; i < guess.length(); i++) {
            if (flag[i])
                continue;
            if (cnt[guess.charAt(i)] > 0) {
                cows++;
                cnt[guess.charAt(i)]--;
            }
        }
        res.append(bulls).append('A');
        res.append(cows).append('B');
        return res.toString();
    }
}