package srcs.service;

@SuppressWarnings("serial")
public class MyProtocolException extends RuntimeException {

	public MyProtocolException() {
		super();
	}

	public MyProtocolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MyProtocolException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyProtocolException(String message) {
		super(message);
	}

	public MyProtocolException(Throwable cause) {
		super(cause);
	}

}
