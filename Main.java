package br.edu.ifpb.pad.calculator;

public class Main {

	public static void main(String[] args) {
		
		Operation sharedResource = new Operation();
		
		InputThread iThread = new InputThread(sharedResource);
		
		ProcessAndOutputThread poThread = new ProcessAndOutputThread(sharedResource);
		
			iThread.start();
			poThread.start();
			
		
	}
}
