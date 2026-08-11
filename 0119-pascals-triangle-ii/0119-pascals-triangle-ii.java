class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> top = new ArrayList<>();
        top.add(1);
        result.add(top);
        if(rowIndex==0) return result.get(rowIndex);
        for(int i = 1;i<=rowIndex;i++){
            List<Integer> pre = result.get(i-1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 0;j<i-1;j++){
                temp.add(pre.get(j) + pre.get(j+1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result.get(rowIndex);
    }
}