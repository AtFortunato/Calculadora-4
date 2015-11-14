package br.edu.ifpb.pad.calculator;

import java.util.Scanner;

public class InputThread extends Thread {
	
	private Operation sharedResource;
	
	public InputThread(Operation sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		Scanner input = new Scanner(System.in);
		
		int a, b;
		char op;
		
		while(true){
			
			
			a = input.nextInt();
			op = input.next().charAt(0);
			b = input.nextInt();
			
			sharedResource.setOperation(a, op, b);
		}
	}
}
