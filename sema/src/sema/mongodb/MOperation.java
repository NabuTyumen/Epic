package sema.mongodb;

import sema.model.AEntry;
import sema.model.IEntry;



public class MOperation {
	

	 static final int UPDATE=1;
	 static final int DELETE=2;

	
	public MOperation(int operation, IEntry data) {
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
	public IEntry getData() {
		return data;
	}
	public void setData(IEntry data) {
		this.data = data;
	}
	private int operation;
	private IEntry data;

}
