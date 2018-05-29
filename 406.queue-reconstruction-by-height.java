/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (56.41%)
 * Total Accepted:    46.4K
 * Total Submissions: 82.3K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
       Arrays.sort(people, (a, b)-> {
           if (a[1] != b[1])
               return a[1] - b[1];
           else
               return a[0] - b[0];
       });
        for (int i = 0; i < people.length; i++) {
            int cnt = 0;
            int index = 0;
            for (int j = 0; j < i; j++) {
                if (people[j][0] >= people[i][0]) {
                    cnt++;
                    if (cnt == people[i][1])
                        index = j + 1;
                    if (cnt > people[i][1])
                        break;
                }
            }
            if (cnt == people[i][1])
                continue;
            while (people[index][0] < people[i][0])
                index++;
            int[] tmp = Arrays.copyOf(people[i], 2);
            for (int k = i; k > index; k--) {
                people[k] = people[k - 1];
            }
            people[index] = tmp;
        }
        return people;
    }
}
