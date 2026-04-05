class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<Integer, List<String>> map = new HashMap<>();
       for(int i=0;i<strs.length;i++){
        int sum=0;
        for(int j=0;j<strs[i].length();j++){
            sum+=((strs[i].charAt(j)-'a'+1)*(strs[i].charAt(j)-'a'+1)*(strs[i].charAt(j)-'a'+1));
        }
        List<String> arr = map.getOrDefault(sum,new ArrayList<String>());
        arr.add(strs[i]);
        map.put(sum,arr);
       }

       List<List<String>> result = new ArrayList<>();
       for(List<String> temp: map.values()){
        result.add(temp);
       }
       return result;

    }
}
