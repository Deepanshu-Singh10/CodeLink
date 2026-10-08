class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int found = 0;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Integer num:map.values()){
            if(!set.contains(num)){
                set.add(num);
            }
            else return false;
        }
        return true;

    }
}