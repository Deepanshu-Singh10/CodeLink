class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int num: candies){
            max = Math.max(max,num);
        }
        for(int num: candies){
            if((num + extraCandies) < max){
                list.add(false);
            }
            else list.add(true);
        }
        return list;
    }
}