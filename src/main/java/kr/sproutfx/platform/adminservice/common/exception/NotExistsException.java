package kr.sproutfx.platform.adminservice.common.exception;

import org.springframework.http.HttpStatus;

import kr.sproutfx.platform.adminservice.common.enumeration.ErrorStatus;
import lombok.Getter;

@Getter
public class NotExistsException extends RuntimeException {
    private final ErrorStatus errorStatus = ErrorStatus.NOT_EXISTS;
    private final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
}
