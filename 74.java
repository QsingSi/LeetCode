class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] < target)
                left = mid + 1;
            else
                right = mid;
        }
        if (left == m)
            left--;
        else if (matrix[left][0] == target)
            return true;
        else
            left--;
        if (left < 0)
            return false;
        int row = left;
        System.out.println(row);
        left = 0;
        right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        System.out.println(left);
        if (left == n)
            return false;
        if (matrix[row][left] != target)
            return false;
        return true;
    }
}