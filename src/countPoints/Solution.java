package countPoints;

import java.util.*;

public class Solution {
    public static int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for(char i ='0';i<='9';i++){
            map.put(i,new HashSet<>());
        }
        //System.out.println(map);
        for(int i=0;i<rings.length();i=i+2){
            char c1 = rings.charAt(i);
            char c2 = rings.charAt(i+1);
            Set<Character> s = map.get(c2);
            s.add(c1);
            map.put(c2,s);
        }
        int count = 0;
        for(Map.Entry<Character,Set<Character>> entry:map.entrySet()){
            if(entry.getValue().size()>=3){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        System.out.println(countPoints(rings));
    }
}
