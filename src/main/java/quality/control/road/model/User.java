package quality.control.road.model;

import io.swagger.annotations.ApiParam;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiParam(value = "Идентификатор")
    private Long id;
    @Column(unique = true)
    @ApiParam(value = "Логин")
    private String username;//почта
    @ApiParam(value = "Пароль")
    private String password;
    @ApiParam(value = "Флаг недавно был")
    private boolean accountNonExpired;//если давно не заходили
    @ApiParam(value = "Флаг не заблокирован")
    private boolean accountNonLocked; //если не заблокированный
    @ApiParam(value = "Флаг учетные данные не истекли")
    private boolean credentialsNonExpired; //если настройка учетных данных не истекли
    @ApiParam(value = "Флаг активации аккаунта")
    private boolean enabled;//активированный
    @ApiParam(value = "Имя")
    private String firstname;
    @ApiParam(value = "Фамилие")
    private String secondname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiParam(value = "Проблемные зоны")
    private List<RoadProblem> roadProblems;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id"))
    @Enumerated(EnumType.STRING)
    @ApiParam(value = "Роли")
    private List<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    public void unBlockAccount() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }
}
