class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[52];
        Set<Character> chars = new HashSet<Character>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq[getPlace(c)]++;
            chars.add(c);
        }

        int left = 0;
        int right = 0;

        int minLen = Integer.MAX_VALUE;
        int lastL = 0;
        int lastR = 0;

        while (right < s.length()) {
            char cR = s.charAt(right);
            int pR = getPlace(cR);

            // Expand window
            freq[pR]--;

            if (freq[pR] == 0) {
                chars.remove(cR);
            }

            // Window contains all required characters
            while (chars.isEmpty()) {

                // Record smallest window
                int curLen = right - left + 1;

                if (curLen < minLen) {
                    minLen = curLen;
                    lastL = left;
                    lastR = right;
                }

                // Try shrinking from the left
                char cL = s.charAt(left);
                int pL = getPlace(cL);

                freq[pL]++;

                if (freq[pL] > 0) {
                    chars.add(cL);
                }

                left++;
            }

            right++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(lastL, lastR + 1);
    }

    public int getPlace(char c) {
        int place = c - 'A';
        if (place > 25) {
            place -= 6;
        }
        return place;
    }
}