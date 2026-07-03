class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(result,new ArrayList<>(),nums,0);
      return result;
    }
    public void solve(List<List<Integer>> res,List<Integer>temp,int [] arr,int start){
        res.add(new ArrayList<>(temp));
        for(int i = start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]) continue;
            temp.add(arr[i]);
            solve(res,temp,arr,i+1);
            temp.remove(temp.size()-1);
        }
    }
}