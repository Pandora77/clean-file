package com.pr.exeptions;

public class CommodityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5372206083247690419L;

	public CommodityNotFoundException(String message) {
		super(message);
	}

	
	
}
