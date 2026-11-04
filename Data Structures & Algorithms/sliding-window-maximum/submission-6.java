class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int[] solution = new int[len - (k - 1)];
        Deque<Integer> largest = new ArrayDeque<>();

        while (right < len) {

            while (!largest.isEmpty() && nums[right] >= nums[largest.peekLast()]) {
                largest.pollLast();
            }

            largest.offerLast(right);

            if (right >= left + k - 1) {
                solution[left] = nums[largest.peekFirst()];

                if (largest.peekFirst() == left) {
                    largest.pollFirst();
                }

                left++;
            }

            right++;
        }

        return solution;
    }
}