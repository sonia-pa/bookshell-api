package com.soniapa.BooksBackend.utility;

import com.soniapa.BooksBackend.exception.BookException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.soniapa.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(BookException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}


}
