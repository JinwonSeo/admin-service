package kr.sproutfx.platform.adminservice.common.enumeration;

import lombok.Getter;

@Getter
public enum ErrorStatus {
    // Unhandled
    UNHANDLED("-1", "Unhandled exception"),
    // 401
    UNAUTHORIZED("401-01", "Incorrect authentication"),
    // 422
    UNPROCESSABLE_ENTITY("422-01", "Unprocessable entity"), 
    ALREADY_EXISTS("422-02", "Already exists"),
    ALREADY_IN_USE("422-03", "Already in use"),
    NOT_EXISTS("422-04", "Not exists")
    ;
    
    private final String value;
    private final String reason;
    
    private ErrorStatus(String value, String reason) {
        this.value = value;
        this.reason = reason;
    }
}