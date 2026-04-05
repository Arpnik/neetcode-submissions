class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++) {
            Character ch = t.charAt(i);
            int count = map.getOrDefault(ch,0) - 1;
            if(count < 0)
                return false;
            map.put(ch, count);
        }
        for(Character ch: map.keySet()){
            int count = map.getOrDefault(ch,0);
            if(count!=0)
               return false;
        }
        return true;
    }
}
