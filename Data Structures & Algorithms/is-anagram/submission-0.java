class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        int[] counts = new int [26];

        for(int i = 0; i<s.length(); i++){
            int sIndex = s.charAt(i) - 97;
            int tIndex = t.charAt(i) - 97;

            counts[sIndex]++;
            counts[tIndex]--;
        }

        for(int i =0; i<counts.length; i++){
            if(counts[i]!=0){
                return false;
            }
        }
        return true;
    }
}
