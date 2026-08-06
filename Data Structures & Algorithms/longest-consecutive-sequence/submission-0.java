class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int best = 0;
        for (int n : set) {
            if (set.contains(n - 1)) continue;   // not a head, skip

            int length = 1;
            while (set.contains(n + length)) length++;

            best = Math.max(best, length);
        }
        return best;
    }
}