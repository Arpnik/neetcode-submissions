class Solution {
    // 1 0 0 1 1 0
    // 1 1 1 0 1 1
//6-3=3
    //1 1 0 0
    //0 1 0 1 
    private int subtract(int a, int b){
        boolean changeSign=false;
        int num1=0,num2=0, sum=0, borrow=0, num1Bit, num2Bit;
        if(a>0&&b<0){
            if(a<-b){
                changeSign=true;
                num1=-b;
                num2=a;
            } else {
                num1=a;
                num2=-b;
            }
        }
        if(b>0&&a<0){
            if(-a>b){
                changeSign=true;
                num1=-a;
                num2=b;
            } else {
                num1=b;
                num2=-a;
            }
        }
        //10000
        //01110
        int bitPlace = 0;
        borrow=0;
        System.out.println(num1+" "+num2);
        while(num1!= 0|| num2!=0) {
            num1Bit = num1%2;
            num2Bit = num2%2;
            System.out.println(sum+" "+num1Bit+" "+num2Bit);

            if(num1Bit==num2Bit){
                if(borrow==1){
                    sum = sum|(1<<bitPlace);
                }
            } else if(num1Bit==1 && num2Bit==0){
                if(borrow==1){
                    borrow=0;
                } else{
                    sum = sum|(1<<bitPlace);
                }
            } else {
                if(borrow!=1)
                    sum = sum|(1<<bitPlace);
                borrow = 1;
            }

            num1=num1>>1;
            num2=num2>>1;
            bitPlace++;
        }
       return changeSign?-sum:sum;
    }

    public int getSum(int a, int b) {
        if(a==0)
            return b;
        if(b==0)
            return a;
       boolean changeSign = false;
       if(a<0 && b<0){
        a=-a;
        b=-b;
        changeSign=true;
       } 
       if((a>0&&b<0)||(b>0&&a<0))
            return subtract(a,b);
       int sum=0;
       int bitPlace=0;
       int aBit,bBit;
       int carry=0;
       while(a!=0 || b!=0){
        aBit = a%2;
        bBit = b%2;

        if(aBit==bBit) {
            if(aBit==1){
                if(carry==1){
                    sum = sum|(1<<bitPlace);
                } else {
                    carry=1;
                }
            } else {
                if(carry==1){
                    carry=0;
                    sum = sum|(1<<bitPlace);
                }
            }
        } else {
            if(carry==1){
                carry=1;
            } else {
                sum = sum|(1<<bitPlace);
            }
        }

        // System.out.println(sum);

        a=a>>1;
        b=b>>1;
        bitPlace++;
       }

        if(carry==1){
            sum = sum|(1<<bitPlace);
        }

       return changeSign?-sum:sum;
    }
}
