package kr.sproutfx.platform.adminservice.common.exception;

import org.springframework.http.HttpStatus;

import kr.sproutfx.platform.adminservice.common.enumeration.ErrorStatus;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException {
    private final ErrorStatus errorStatus = ErrorStatus.UNAUTHORIZED;
    private final HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
}
