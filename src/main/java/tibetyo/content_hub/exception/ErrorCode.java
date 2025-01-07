package tibetyo.content_hub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    EMAIL_DUPLICATE(HttpStatus.CONFLICT, "USER-001", "Email duplicated"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-002", "User not found"),
    LIKE_ALREADY_EXISTS(HttpStatus.CONFLICT, "LIKE-001", "Like already exists"),
    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "LIKE-002", "Like not found"),
    CONTENT_NOT_FOUND(HttpStatus.NOT_FOUND, "CONTENT-001", "Content not found"),
    OTT_NOT_FOUND(HttpStatus.NOT_FOUND, "OTT-001", "Ott not found"),
    OTT_ALREADY_EXISTS(HttpStatus.CONFLICT, "OTT-002", "Ott already exists"),
    AVAILABILITY_NOT_FOUND(HttpStatus.NOT_FOUND, "AVAILABILITY-001", "Availability not found"),
    AVAILABILITY_ALREADY_EXISTS(HttpStatus.CONFLICT, "AVAILABILITY-002", "Availability already exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER-001", "Internal server error"),
    ;

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
