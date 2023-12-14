public class Check {
    private String exp;
    private int expSize;
    private char testCh, openPair;
 
    public boolean testPair(String exp){
    	char operator, testCh;
		int idx =0;
		ListStack<Character> stack = new ListStack<Character>();
		testCh = exp.charAt(idx);
		for (int i=0;i<exp.length();i++)  {
			testCh = exp.charAt(i);
			switch(testCh) {
			case'(':
			case'{':
			case'[':
				stack.push(testCh);
				break;
			case')':
			case'}':
			case']':
				if(stack.isEmpty())
					return false;
                else{
                    openPair = stack.pop();
                    if((openPair==')') && (testCh!='(') || 
                       (openPair==']') && (testCh!='[') || 
                       (openPair=='}') && (testCh!='{')){
                        return false;
 
                    }else{
                        break;
                    }
                }
            }
        }
 
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        
    }
}
 

    public static void main(String[] args) {
      
        String st = "{ { ( ) { ( ) } } }";
		String st2 = "{ { ( ) { ( ) } ) ( ) }";
	
		Check test = new Check();
		if(test.testPair(st)) {
			System.out.println(st + "는 짝이 맞는 수식입니다");
		}
		else {
			System.out.println(st + "는 짝이 맞지 않은 수식입니다");			
		}
		if(test.testPair(st2)) {
			System.out.println(st2 + "는 짝이 맞는 수식입니다");
		}
		else {
			System.out.println(st2 + "는 짝이 맞지 않은 수식입니다");			
		}
    }
}


