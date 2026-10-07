class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       int n = distance.length;
       int total = 0;
       for(int d:distance){
        total +=d;
       }
       int shortest = 0;
       for(int i =start;i!=destination;i=(i+1)%n){
        shortest += distance[i];
       }
       return Math.min(shortest,total-shortest);
    }
}