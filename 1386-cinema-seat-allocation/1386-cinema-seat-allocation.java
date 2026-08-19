class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }
        int ans = (n - map.size()) * 2;
        for (int row : map.keySet()) {
            int mask = map.get(row);
            
            boolean leftAvailable = (mask & (1<<2 | 1<<3 | 1<<4 | 1<<5)) == 0;
            boolean rightAvailable = (mask & (1<<6 | 1<<7 | 1<<8 | 1<<9)) == 0;
            boolean middleAvailable = (mask & (1<<4 | 1<<5 | 1<<6 | 1<<7)) == 0;
            
            if (leftAvailable && rightAvailable) {
                ans += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                ans += 1;
            }
        }
        
        return ans;
    }
}