class Solution {
    public int missingInteger(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        int n = nums.length;
        int prefix =nums[0];
       for(int i= 1;i<n;i++){
        if(nums[i]!=nums[i-1]+1) break;
        prefix+=nums[i];
       }
       for(int i =0;i<n;i++){
        list.add(nums[i]);
       }
       while(list.contains(prefix)){
        prefix++;
       }
       return prefix;  
    }
}