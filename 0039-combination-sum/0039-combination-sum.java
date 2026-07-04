class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(result,new ArrayList<>(),candidates,target,0);
        return result;
    }
    public void solve(List<List<Integer>> res, List<Integer> temp,int []num,int target,int start){
        if(target == 0){
        res.add(new ArrayList<>(temp));
         return ;
        }
        if(target<0) return ;
        for(int i =start;i<num.length;i++){
          temp.add(num[i]);
          solve(res,temp,num,target-num[i],i);
          temp.remove(temp.size()-1);
            
        }
    }
}