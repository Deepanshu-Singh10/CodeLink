class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> rankOfNum = new HashMap<>();
        int rank = 1;
        for(int i = 0;i<temp.length;i++){
            if(i>0&& temp[i]>temp[i-1]){
                rank++;
            }
            rankOfNum.put(temp[i],rank);
        }
        for(int i =0;i<arr.length;i++){
            arr[i] = rankOfNum.get(arr[i]);
        }
        return arr;
    }
}