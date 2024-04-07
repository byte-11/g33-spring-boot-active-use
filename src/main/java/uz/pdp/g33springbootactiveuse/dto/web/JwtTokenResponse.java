package uz.pdp.g33springbootactiveuse.dto.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtTokenResponse {
    private String accessToken;
    private String refreshToken;
    private final LocalDateTime time = LocalDateTime.now();

    public JwtTokenResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
