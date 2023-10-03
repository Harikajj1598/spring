package org.jsp.merchantapp.execption;

public class InvaildCredentialsException  extends RuntimeException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invaild phone / password / name/ email ";
	}

}
