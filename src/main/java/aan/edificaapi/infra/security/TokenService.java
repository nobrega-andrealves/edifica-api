package aan.edificaapi.infra.security;

import aan.edificaapi.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${security.token.secret}")
    private String secret;
    public String gerarToken(Usuario usuario){

        try {

            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Edifica")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .withClaim("id", usuario.getId()) //withClaim é chave varlor e pode ser chamado diversas vezes para passar qualquer informação
                    .sign(algoritmo);

        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    public String getSubject(String tokenJWT){
        DecodedJWT decodedJWT;
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Edifica")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
