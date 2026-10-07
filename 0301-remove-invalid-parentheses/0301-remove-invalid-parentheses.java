class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> qu = new LinkedList<>();
        Set<String> st = new HashSet<>();
        List<String> result = new ArrayList<>();
        qu.offer(s);
        st.add(s);
        
        while (!qu.isEmpty()) {
            int size = qu.size();
            boolean found = false;
            
            for (int i = 0; i < size; i++) {
                String curr = qu.poll();
                
                if (isValid(curr)) {
                    result.add(curr);
                    found = true;
                }
                
                if (!found) {
                    for (int j = 0; j < curr.length(); j++) {
                        char c = curr.charAt(j);
                        if (c != '(' && c != ')') continue; 
                        
                        String next = curr.substring(0, j) + curr.substring(j + 1);
                        
                        if (!st.contains(next)) {
                            st.add(next);
                            qu.offer(next);
                        }
                    }
                }
            }
            
            if (found) {
                return result;
            }
        }
        
        return result;
    }
    
    boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') balance--;
            
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}