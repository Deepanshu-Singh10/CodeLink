class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long,Integer> map = new HashMap<>();
        int max =0;

        for(List<Integer> num: wall){
            long sum = 0;
           for(int i = 0; i<num.size()-1; i++){
                sum+=num.get(i);
                map.put(sum,map.getOrDefault(sum,0)+1);
                max = Math.max(max,map.get(sum));
            }
        }
        return wall.size() - max;
    }
}