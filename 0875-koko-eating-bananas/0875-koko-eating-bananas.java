class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int low = 1;
        int high = max;
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;
            for (int i = 0; i < n; i++) {
                hours += Math.ceil((double)piles[i] / mid);
            }
            if(hours<=h){
                result = mid;
                high= mid-1;
            }
            else {
                low= mid+1;
            }
        }
        return result;
    }

}