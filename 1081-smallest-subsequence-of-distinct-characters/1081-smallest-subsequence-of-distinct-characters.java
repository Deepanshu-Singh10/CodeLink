class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            count[curr - 'a']--;
            
            if (visited[curr - 'a']) {
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek() > curr && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }
            
            stack.push(curr);
            visited[curr - 'a'] = true;
        }
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        
        return ans.reverse().toString();
    }
}