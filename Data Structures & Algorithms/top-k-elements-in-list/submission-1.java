

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Number -> frequency
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(
                num,
                frequencies.getOrDefault(num, 0) + 1
            );
        }

        // Index represents frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : frequencies.keySet()) {
            int frequency = frequencies.get(num);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        // Search from highest frequency to lowest
        for (int frequency = buckets.length - 1;
             frequency >= 0 && resultIndex < k;
             frequency--) {

            if (buckets[frequency] != null) {
                for (int num : buckets[frequency]) {
                    result[resultIndex] = num;
                    resultIndex++;

                    if (resultIndex == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}