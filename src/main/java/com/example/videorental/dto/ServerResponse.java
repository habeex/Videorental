package com.example.videorental.dto;

import com.example.videorental.constant.ServerResponseStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.http.HttpStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ServerResponse {

	private boolean success;
	private String message;
	private Object data;
	
	@JsonIgnore
	private int status;

	public ServerResponse() {
	}

	public ServerResponse(boolean success, String message, Object data, int status) {
		this.success = success;
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public void setResponse(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ServerResponse{" +
				"success=" + success +
				", message='" + message + '\'' +
				", data=" + data +
				", status=" + status +
				'}';
	}

	public static HttpStatus getStatus(int status) {
        return HttpStatus.valueOf(status);
    }

	public int getStatus() {
		return status;
	}

	public static ServerResponse exceptionMessage(Exception e){
		e.printStackTrace();
		return new ServerResponse(false,
				"Something went wrong",
				"",
				ServerResponseStatus.INTERNAL_SERVER_ERROR);
	}

	public static ServerResponse successResponse(String message, Object data){
		return new ServerResponse(true,
				message,
				data,
				ServerResponseStatus.OK);
	}

	public static ServerResponse badRequest(String message){
		return new ServerResponse(false,
				message,
				"",
				ServerResponseStatus.FAILED);
	}

}

