class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] tmp = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0)
                tmp[i] = 1;
            else {
                for (int j = i; j >= 0; j--) {
                    if (j == 0 || j == i)
                        tmp[j] = 1;
                    else {
                        tmp[j] += tmp[j - 1];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(tmp));
        return IntStream.of(tmp).boxed().collect(Collectors.toList());
    }
}