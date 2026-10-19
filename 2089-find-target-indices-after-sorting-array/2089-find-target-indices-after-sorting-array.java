class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(target==nums[i]){
                result.add(i);
            }
        }
        return result;
    }
}