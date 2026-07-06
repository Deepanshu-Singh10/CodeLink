class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int n = intervals.length;
        int remain = n;
        int max = 0;
        for(int i =0;i<n;i++){
           int current = intervals[i][1];
           if(current<= max){
            remain--;
           }
           else{
            max =current;
           }
        }
        return remain;
    }
}