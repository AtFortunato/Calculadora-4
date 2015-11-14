package br.edu.ifpb.pad.calculator;

public class ProcessAndOutputThread extends Thread{
	private Operation sharedResource;
	
	public ProcessAndOutputThread(Operation sharedResource) {
		this.sharedResource = sharedResource;
	}
	
	@Override
	public void run() {
		Calculator calculator = new Calculator();
		Operation aux = null;
		int a, b, res = 0;
		
		while(true) {
			/*Gets the values of the operation in the shared resource
			 * can't be directly because the parallel processing is working*/
			aux = sharedResource.getOperation();
			
			a = aux.getOperating1();
			b = aux.getOperating2();
			
			switch(aux.getOperator()){
				case '+': res = calculator.sum(a, b); 
						  break;
				case '-': res = calculator.subtracts(a, b); 
				  		  break;
				case '*': res = calculator.multiply(a, b); 
				  	      break;
				case '/': res = calculator.divides(a, b); 
				  	      break;
			}
			
			System.out.println(res);			
		}
	}
}
