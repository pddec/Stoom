package br.com.stoom.CRUD.enums;

import org.json.JSONObject;

public enum ClientMessagens {
	
	CREATED("Iten Created With Success"),
	DELETED("Iten Deleted With Success"),
	UPDATED("Iten Updated With Success"),
	ERROR("Operation Wasn't Completed Due: ");

	private String msg;

	ClientMessagens(String msg) {
		this.msg = msg;
	}
	
	public String ErrorClient(String msg) {
		return this.createResponse("reject", msg);
	}
	
	public String SuccessClient(String msg) {
		return this.createResponse("resolve", msg);
	}
	
	private String createResponse(String type, String msg) {
		return new JSONObject()
                .put(type, this.msg + msg)
                .toString();
	}

}
