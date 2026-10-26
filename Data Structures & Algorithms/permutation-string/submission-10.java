//permutation is all different arrnagments of the characters in a string 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        Hashtable<Character, Integer> chars = new Hashtable<Character, Integer>();
        int[][] letters = new int[2][26];
        int sLen = s1.length();
       
        //puts all chars & counts of char in s1 
        for(int i = 0; i < sLen; i++){
            char c = s1.charAt(i);
            int cnt = chars.getOrDefault(s1.charAt(i), - 1);
            if(cnt == -1){
                chars.put(c, 1);
            } else{
                chars.put(c, cnt + 1);
            }
        }

        int left = 0;
        while(left != s2.length()){
            char cL = s2.charAt(left);
            int charCntL = chars.getOrDefault(cL, -1);
            if(charCntL == -1){
                left++;
            } else{
                int ascL = cL - 97;
                letters[0][ascL]++;
                break;
            }
        }
        
        int right = left + 1;
        int iter = 0;
        int s2Len = s2.length();

        // when to modify window
            // if we found character not in the string
                // in this case we always try to find a permutation from the next character
            // if there are more occurences we found of the character then there are in the string
                // in this case move our left pointer until we get rid of the first occurence
        //when we found
            // when our window size is equal to the strings length given we modified with conditons set
        while(right <= s2Len){

            int curLen = right - left;
            
            if(curLen == sLen){
                return true;
            } else if(right == s2Len){
                return false;
            }

            char c = s2.charAt(right);
            int asc = c - 97;
            int charCnt = chars.getOrDefault(c, -1);

            if(charCnt == - 1){
                left = right;
                while(left != s2.length()){
                    char cL = s2.charAt(left);
                    int charCntL = chars.getOrDefault(cL, -1);
                    if(charCntL == -1){
                        left++;
                    } else{
                        int ascL = cL - 97;
                        letters[0][ascL] = 1;
                        letters[1][ascL] = iter + 1;
                        break;
                    }
                }
                iter++;
                right = left + 1;

            } else {

                if(letters[1][asc] != iter){
                    letters[1][asc] = iter;
                    letters[0][asc] = 0;
                }

                if(letters[0][asc] == charCnt && left != right){
                    char cL = s2.charAt(left);
                    int ascL = cL - 97;
                    letters[0][ascL]--;
                    left++;
                } else {
                    letters[0][asc]++;
                    right++;
                }
            }
        }
        return false;
    }
}

