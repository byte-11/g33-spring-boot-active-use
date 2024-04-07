package uz.pdp.g33springbootactiveuse.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.g33springbootactiveuse.config.auditing.Auditor;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @Builder.Default
    @Column(columnDefinition = "bigint default 1")
    private long roles = Role.USER_ROLE.getFlag();

    @Column(columnDefinition = "boolean default true")
    @Builder.Default
    private boolean enabled = Boolean.TRUE;
}
