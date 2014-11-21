package mf.uow;

import mf.Data;

public class Operation {
	
	public Operation(int operation, Data data) {
		super();
		this.setOperation(operation);
		this.setData(data);
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	private int operation;
	private Data data;

}
