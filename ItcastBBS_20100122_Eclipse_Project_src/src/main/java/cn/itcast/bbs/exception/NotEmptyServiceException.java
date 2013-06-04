package cn.itcast.bbs.exception;


@SuppressWarnings("serial")
public class NotEmptyServiceException extends ServiceException {

	public NotEmptyServiceException() {
		super();
	}

	public NotEmptyServiceException(String message, Throwable rootCause) {
		super(message, rootCause);
	}

	public NotEmptyServiceException(String message) {
		super(message);
	}

	public NotEmptyServiceException(Throwable rootCause) {
		super(rootCause);
	}

}
