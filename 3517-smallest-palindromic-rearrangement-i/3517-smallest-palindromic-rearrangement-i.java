class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        String middle = "";
        int freSize = freq.length;

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (freq[i] % 2 != 0) {
                middle = String.valueOf(ch);
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                result.append(ch);
            }
        }
        String firstHalf = result.toString();
        String secondHalf = result.reverse().toString();
        return firstHalf + middle + secondHalf;
    }
}