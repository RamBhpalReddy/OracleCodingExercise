package com.java.ram.oracleCodingExercise.Exception;
/*User defined Exception*/
public class DataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataException(String errorMsg) {
		super(errorMsg);
	}

}
