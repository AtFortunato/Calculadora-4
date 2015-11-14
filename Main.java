package br.edu.ifpb.pad.calculator;

public class Main {

	public static void main(String[] args) {
		/*Shared Resource by Two Threads*/
		Operation sharedResource = new Operation();
		
		/*Thread that will read the operations*/
		InputThread iThread = new InputThread(sharedResource);
		
		/*Thread that will process and print the result of operations*/
		ProcessAndOutputThread poThread = new ProcessAndOutputThread(sharedResource);
		
		/*Parallel Processing*/
		
			/*Start the input thread*/
			iThread.start();
			/*Start the process and output thread*/
			poThread.start();
			
		/*-----------------*/
	}
}
