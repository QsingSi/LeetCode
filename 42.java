class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 0 || height.length == 1)
            return res;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < height.length;) {
            if (st.empty() || height[i] <= height[st.peek()])
                st.push(i++);
            else {
                int tmp = st.pop();
                if (st.empty())
                    continue;
                res += (Math.min(height[i], height[st.peek()]) - height[tmp]) * (i - st.peek() - 1);
            }
        }
        return res;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if (st.isEmpty() || h >= heights[st.peek()])
                st.push(i);
            else {
                int tp = st.pop();
                max = Math.max(max, heights[tp] * (st.isEmpty() ? i : i - st.peek() - 1));
                i--;
            }
        }
        return max;
    }
}