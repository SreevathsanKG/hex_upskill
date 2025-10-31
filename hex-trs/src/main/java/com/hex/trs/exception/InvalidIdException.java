package com.hex.trs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String message;
}
