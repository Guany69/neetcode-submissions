class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        String sub = "";

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int duplicateIndex = sub.indexOf(current);

            if (duplicateIndex != -1) {
                sub = sub.substring(duplicateIndex + 1);
            }

            sub += current;
            len = Math.max(len, sub.length());
        }

        return len;
    
    }
}