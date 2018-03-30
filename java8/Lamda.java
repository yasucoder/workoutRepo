package java8feature;

public class Lamda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GreetingService greetingservices = (message)->System.out.println("----------Message-----\n"+message);
		greetingservices.sayMessage("Stay Focussed");
		
		MathOperation addtion = (int a, int b) -> a+b;
		MathOperation subtraction = (a,b) -> a-b;
		MathOperation division = (a,b) ->{
			if (b==0) return 0;
			return a/b;	};
		MathOperation multiplication = (a,b) -> a*b;	
												
			
		int add = Lamda.operate(10, 20, addtion)	;
		System.out.println(add);			
		
	}

	interface GreetingService {
		void sayMessage(String Message);
		
	}
	
	interface MathOperation {
		int operation(int a , int b);
	}
	public static int operate(int a, int b, MathOperation cal){
		return cal.operation(a, b);
	}
}
