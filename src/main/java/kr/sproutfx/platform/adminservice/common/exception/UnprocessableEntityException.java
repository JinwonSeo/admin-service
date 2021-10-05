package kr.sproutfx.platform.adminservice.common.exception;

import org.springframework.http.HttpStatus;

import kr.sproutfx.platform.adminservice.common.enumeration.ErrorStatus;
import lombok.Getter;

@Getter
public class UnprocessableEntityException extends RuntimeException {
    private final ErrorStatus errorStatus = ErrorStatus.UNPROCESSABLE_ENTITY;
    private final HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
}