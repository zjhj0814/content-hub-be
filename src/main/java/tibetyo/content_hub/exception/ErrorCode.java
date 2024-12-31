package tibetyo.content_hub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    EMAIL_DUPLICATE(HttpStatus.CONFLICT, "USER-001", "EMAIL DUPLICATED"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-002", "USER NOT FOUND"),
    LIKE_ALREADY_EXISTS(HttpStatus.CONFLICT, "LIKE-001","LIKE ALREADY EXISTS"),
    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "LIKE-002", "LIKE NOT FOUND"),
    CONTENT_NOT_FOUND(HttpStatus.NOT_FOUND, "CONTENT-001", "CONTENT NOT FOUND"),
    OTT_NOT_FOUND(HttpStatus.NOT_FOUND, "OTT-001", "OTT NOT FOUND"),
    AVAILABILITY_NOT_FOUND(HttpStatus.NOT_FOUND, "AVAILABILITY-001", "AVAILABILITY NOT FOUND"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER-001", "INTERNAL SERVER ERROR"),
    ;

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
