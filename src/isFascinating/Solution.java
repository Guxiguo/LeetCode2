package isFascinating;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isFascinating(int n) {
        int n2 = 2*n;
        int n3 = 3*n;
        Set<Character> set = new HashSet();
        String str = String.valueOf(n)+String.valueOf(n2)+String.valueOf(n3);
        for(char c : str.toCharArray()){
            if(c=='0'){
                return false;
            }
            else{
                if(set.contains(c)){
                    return false;
                }
                set.add(c);

            }

        }
        if(set.size()==9){
            return true;
        }
        return false;
    }
}