package uz.pdp.g33springbootactiveuse.dto.web;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private String errorConde;

    private String errorMessage;

    private Object body;

    private String path;

    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();
}
