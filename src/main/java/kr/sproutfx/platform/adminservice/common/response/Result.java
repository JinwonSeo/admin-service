package kr.sproutfx.platform.adminservice.common.response;

import kr.sproutfx.platform.adminservice.common.enumeration.ErrorStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class Result<T> {
    private boolean succeeded;
    private Error error;
    private T data;

    public Result(T result) {
        this.succeeded = true;
        this.data = result;
        this.error = null;
    }

    public Result(ErrorStatus errorStatus) {
        this.succeeded = false;
        this.data = null;
        this.error = new Error(errorStatus);
    }
}
