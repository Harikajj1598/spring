package org.jsp.merchantapp.execption;

public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invaild Merchant Id";
	}

}
