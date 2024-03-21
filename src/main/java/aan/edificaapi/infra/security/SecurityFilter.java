package aan.edificaapi.infra.security;

import aan.edificaapi.domain.usuario.UsuarioRepository;
import aan.edificaapi.infra.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenInformado = recuperarToken(request);

        if (tokenInformado != null){

            var subject = tokenService.getSubject(tokenInformado);
            var usuario = repository.findByLogin(subject);

            var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {

        var autorizationHeader = request.getHeader("Authorization");

        if (autorizationHeader != null){
            return autorizationHeader.replace("Bearer ", "");
        }

        return null;
    }
}