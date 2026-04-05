class Solution {

    private static int convertNum(char first, char second){
        return (first-'0')*10 + (second-'0');
    }

    private static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public int numDecodings(String s) {
        if(Objects.isNull(s)|| s.length()<=0)
            return 0;
        int[] count = new int[s.length()];
        if(s.charAt(0)!='0')
            count[0] = 1;
        char first, second;
        int num;
        for(int i=0;i<s.length();i++){
            System.out.println(i);
            // count[i] = 0;
            first = s.charAt(i);
            if(first!='0'){
                if(i>0)
                    count[i] += count[i-1];
            }
            display(count);
            if(i-1>=0){
                second = s.charAt(i-1);
                if(second=='0')
                    continue;
                num = convertNum(second, first);
                System.out.println(num);
                if(num>=1 && num<=26){
                    count[i] += ((i-2>=0)?count[i-2]:1);
                }
            }
            display(count);

        }
        return count[s.length()-1];
    }
}
