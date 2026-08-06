class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            int[] counts = new int[26];

            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for (int count : counts) {
                keyBuilder.append('#').append(count);
            }

            String key = keyBuilder.toString();

            groups.computeIfAbsent(key, k -> new ArrayList<>());
            groups.get(key).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}