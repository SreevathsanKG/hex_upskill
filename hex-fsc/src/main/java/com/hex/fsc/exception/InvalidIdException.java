package com.hex.fsc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidIdException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;

}
