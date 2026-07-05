class Solution {
    public List<String> letterCombinations(String digits) {
        String [] keypad = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        List<String>com= new ArrayList<>();
        if(digits.length()==0) return com;
        solve(com,new StringBuilder(),digits,keypad,0);
        return com;
    }
    public void solve(List<String>com,StringBuilder temp,String digit,String[] keys,int index){
        if(index==digit.length()){
            com.add(temp.toString());
            return;
        }
        int button = digit.charAt(index) - '0';
        String letters = keys[button];
        for(int i =0;i<letters.length();i++){
            temp.append(letters.charAt(i));
            solve(com,temp,digit,keys,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}