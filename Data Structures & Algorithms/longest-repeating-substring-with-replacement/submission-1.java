
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int curLen = 0;
        int lengthLongest = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            freq[index]++;

            maxFreq = Math.max(maxFreq, freq[index]);

            curLen = right - left + 1;

            if (curLen - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                curLen--;
            }

            lengthLongest = Math.max(lengthLongest, curLen);
            right++;
        }

        return lengthLongest;
    }
}
