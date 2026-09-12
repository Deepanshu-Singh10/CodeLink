class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> result = new HashMap<>();
        int n = strs.length;
        for(int i = 0;i<n;i++){
            char [] charc = strs[i].toCharArray();
            Arrays.sort(charc);
            String word = new String(charc);
            if(!result.containsKey(word)){
                result.put(word,new ArrayList<>());
            }
            result.get(word).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}