class Solution {

    private static int convertToInt(String num){
        int result = 0;
        int start = 0;
        boolean negative = false;
        if(num.charAt(0)=='-'){
            start=1;
            negative = true;
        }
        for(int index = start; index<num.length();index++){
            result = result*10 + (num.charAt(index)-'0');
        }
        return (negative)?-result:result;
    }

    private static int calculate(String operator, int operand1, int operand2){
        switch(operator){
            case "+": return operand1+operand2;
            case "-": return operand2-operand1;
            case "*": return operand1*operand2;
            case "/": return operand2/operand1;            
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length<0)
            return 0;
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        Set<String> operators = new HashSet<String>();
        operators.add("+"); 
        operators.add("-"); 
        operators.add("*"); 
        operators.add("/"); 
        for(String current: tokens){
            if(operators.contains(current)){
                int intermediate = calculate(current, numbers.pop(), numbers.pop());
                System.out.println(intermediate);
                numbers.push(intermediate);
            } else {
                numbers.push(convertToInt(current));
            }
        }

        return numbers.pop();
    }
}
