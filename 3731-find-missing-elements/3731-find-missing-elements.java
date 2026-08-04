class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int end = nums[nums.length-1];
        int start = nums[0];
        List <Integer> result = new ArrayList<>();
        int j =0;
        for(int i = start; i<=end;i++){
           if(nums[j]==i) j++;
           else result.add(i);
        }
        return result;
    }
}