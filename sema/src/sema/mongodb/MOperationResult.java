package sema.mongodb;

import com.mongodb.WriteResult;

import sema.model.IOperationResult;

public class MOperationResult implements IOperationResult {
	public MOperationResult(WriteResult writeResult) {
		super();
		this.writeResult = writeResult;
	}


	private WriteResult writeResult;
	

	@Override
	public String getResult() {
		
		return null;
	}


	public WriteResult getWriteResult() {
		return writeResult;
	}


	public void setWriteResult(WriteResult writeResult) {
		this.writeResult = writeResult;
	}

}
