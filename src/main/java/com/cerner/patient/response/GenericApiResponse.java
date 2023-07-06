package com.cerner.patient.response;

public class GenericApiResponse<T> {

	private String status;
    private ErrorResponse error;
    private String message;
    private Object data;
    
    
	public GenericApiResponse() {
		super();
	}
	
	public GenericApiResponse(String status, ErrorResponse error, String message, Object data) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
}
