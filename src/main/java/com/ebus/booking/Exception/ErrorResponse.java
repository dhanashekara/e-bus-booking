package com.ebus.booking.Exception;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private int statusCode;
	private String status;
}
