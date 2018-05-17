class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        HashSet<List<Integer>> hashSet = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 4; i++) {
            for (int j = i + 1; j <= num.length - 3; j++) {
                int low = j + 1;
                int high = num.length - 1;

                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];

                    if (sum > target) {
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[low]);
                        temp.add(num[high]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        low++;
                        high--;
                    }
                }
            }
        }

        return result;
    }
}