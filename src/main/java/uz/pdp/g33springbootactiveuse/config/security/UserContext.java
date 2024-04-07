package uz.pdp.g33springbootactiveuse.config.security;

import io.jsonwebtoken.Claims;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.g33springbootactiveuse.domain.Role;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserContext implements UserDetails{
    private Long id;
    private String username;
    private String email;
    private String password;
    private long roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Role.toGrantedAuthorities(roles);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPropertiesByClaims(final Claims claims) {
        this.id = claims.get("id", Long.class);
        this.username = claims.getSubject();
        this.email = claims.get("email", String.class);
        this.roles = claims.get("roles", Long.class);
    }
}
