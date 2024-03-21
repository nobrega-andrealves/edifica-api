package aan.edificaapi.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pessoa_id;

    private String login;
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null; //aqui seria o retorno das autorizações (recursos) que o usuário tem, geralmente através de perfis
        //para compilar o projeto vamos retornar uma coleção básica
        return List.of(new SimpleGrantedAuthority("ROLE_USER")); //o padrão do spring é ROLE_PERFIL EXEMPLO: ROLE_ADMINISTRATOR, ROLE_MANAGER, etc
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        //todo: alterar a tabela e pegar atributo correspondente dela.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //todo: alterar a tabela e pegar atributo correspondente dela.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //todo: alterar a tabela e pegar atributo correspondente dela.
        return true;
    }

    @Override
    public boolean isEnabled() {
        //todo: alterar a tabela e pegar atributo correspondente dela.
        return true;
    }
}