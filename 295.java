public class MedianFinder {

    PriorityQueue<Integer> minPQ; // bigger half poll minimum
    PriorityQueue<Integer> maxPQ; // smaller half poll maximum

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(minPQ.poll());
        if (minPQ.size() < maxPQ.size()) {
            minPQ.add(maxPQ.poll());
            // maintain minPQ to be larger if we add to maxPQ last
            // or else 1, 2, getMedian will return 1.0
        }
    }

    public void addNum2(int num) {
        maxPQ.add(num);
        minPQ.add(maxPQ.poll());
        if (maxPQ.size() < minPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    public double findMedian() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return minPQ.peek();
    }

    public double findMedian2() {
        if (minPQ.size() == maxPQ.size()) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        }
        return maxPQ.peek();
    }
}