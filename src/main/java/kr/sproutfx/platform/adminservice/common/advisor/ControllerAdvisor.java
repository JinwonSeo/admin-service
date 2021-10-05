package kr.sproutfx.platform.adminservice.common.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.sproutfx.platform.adminservice.common.enumeration.ErrorStatus;
import kr.sproutfx.platform.adminservice.common.exception.AlreadyExistsException;
import kr.sproutfx.platform.adminservice.common.exception.AlreadyInUseException;
import kr.sproutfx.platform.adminservice.common.exception.NotExistsException;
import kr.sproutfx.platform.adminservice.common.exception.UnauthorizedException;
import kr.sproutfx.platform.adminservice.common.exception.UnprocessableEntityException;
import kr.sproutfx.platform.adminservice.common.response.Result;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Result<Object>> exception (final Throwable t) {
        return new ResponseEntity<Result<Object>>(new Result<>(ErrorStatus.UNHANDLED), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Result<Object>> unauthorizedException (final UnauthorizedException e) {
        return new ResponseEntity<Result<Object>>(new Result<>(e.getErrorStatus()), e.getHttpStatus());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Result<Object>> alreadyExistsException(final AlreadyExistsException e) {
        return new ResponseEntity<Result<Object>>(new Result<>(e.getErrorStatus()), e.getHttpStatus());
    }

    @ExceptionHandler(AlreadyInUseException.class)
    public ResponseEntity<Result<Object>> alreadyInUseException(final AlreadyInUseException e) {
        return new ResponseEntity<Result<Object>>(new Result<>(e.getErrorStatus()), e.getHttpStatus());
    }

    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity<Result<Object>> notExistsException(final NotExistsException e) {
        return new ResponseEntity<Result<Object>>(new Result<>(e.getErrorStatus()), e.getHttpStatus());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<Result<Object>> unprocessableEntityException (final UnprocessableEntityException e) {
        return new ResponseEntity<Result<Object>>(new Result<>(e.getErrorStatus()), e.getHttpStatus());
    }
}