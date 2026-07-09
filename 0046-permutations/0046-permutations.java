class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        permutation(combinations, new ArrayList<>(), nums);
        return combinations;
    }
    public void permutation(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int number : nums) {
            if (temp.contains(number)) {
                continue;
            }
            temp.add(number);                
            permutation(res, temp, nums);      
            temp.remove(temp.size() - 1);     
        }
    }
}