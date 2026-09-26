class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int [] hash = new int[26];
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a']++;
        }

        int max = 0; int letter = 0;
        for(int i= 0;i<hash.length;i++){
            if(max<hash[i]){
                max = hash[i];
                letter = i;
            }
        }
        if(max > (s.length()+1)/2) return "";
        
        char res [] = new char[n];
        int index = 0;
        while(hash[letter]-- >0){
            res[index]= (char) (letter + 'a');
            index +=2;
        }

        for(int i=0;i<hash.length;i++){
            while(hash[i]-- > 0){
                if(index >= res.length) index =1;
                res[index] = (char) (i + 'a');
                index +=2;
            }
        }

        return String.valueOf(res);
    }
}