class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if (j < 0)
                continue;
            res[0] = i + 1;
            res[1] = j + 1;
        }
        return res;
    }
}