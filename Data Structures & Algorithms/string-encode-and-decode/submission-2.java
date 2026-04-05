class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder("");
        for(String input: strs){
            int len = input.length();
            str.append(String.valueOf(len));
            str.append("#");
            str.append(input);
        }
        String result = str.toString();
        System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList();
        int numChars=0, i=0;
        while(i<str.length()) {
            char current = str.charAt(i);
            if(current!='#'){
                numChars = 10*numChars+(current-'0');
                i++;
            } else {
                System.out.println(numChars+" "+i);
                System.out.println(i+1+" "+(i+numChars+1));
                //0 1 2 3 4 5 6 7 8
                output.add(str.substring(i+1, i+numChars+1));
                if(numChars!=0)
                    i=i+numChars+1;
                else
                    i+=1;
                numChars=0;
            }
        }
        return output;
    }
}
