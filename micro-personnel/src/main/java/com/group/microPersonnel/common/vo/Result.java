package com.group.microPersonnel.common.vo;

import lombok.Data;

@Data
public class Result<T> {
	private int code;
	private String message;
	private T data;

	public Result() {
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static Result ok() {
		return new Result(ResultCode.SUCCESS.code, "success");
	}

	public static <T> Result<T> ok(T data) {
		return new Result(ResultCode.SUCCESS.code, "success", data);
	}

	public static Result failed(String message) {
		return new Result(ResultCode.FAILED.code, message);
	}

	public static <T> Result<T> failed(String message, T data) {
		return new Result(ResultCode.FAILED.code, message, data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public enum ResultCode {
		SUCCESS(200),
		FAILED(500),
		;
		public int code;
		ResultCode(int code) {
			this.code = code;
		}
	}
}
