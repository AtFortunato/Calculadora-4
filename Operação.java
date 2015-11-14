package br.edu.ifpb.pad.calculator;

public class Operation {
	private int operating1;
	private char operator;
	private int operating2;
	private boolean free;
	
	public Operation(){
		free = true;
	}
	
	public int getOperating1() {
		return operating1;
	}

	public void setOperating1(int operating1) {
		this.operating1 = operating1;
	}

	public char getOperator() {
		return operator;
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public int getOperating2() {
		return operating2;
	}

	public void setOperating2(int operating2) {
		this.operating2 = operating2;
	}

	
	public synchronized void setOperation(int operating1, char operator, int operating2) {
		while(!free){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		setOperating1(operating1);
		setOperator(operator);
		setOperating2(operating2);
		
		free = false;
		notifyAll();
	}
	
	
	public synchronized Operation getOperation() {
		while(free){
			try{
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		free = true;
		notifyAll();
		
		return this;
	}
}
