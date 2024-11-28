    package sc.senai.controle_de_estoque.config;

    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.AuthenticationException;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
    import sc.senai.controle_de_estoque.entities.Usuario;

    import com.auth0.jwt.JWT;
    import com.auth0.jwt.algorithms.Algorithm;
    import com.fasterxml.jackson.databind.ObjectMapper;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Date;

    public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
        public static final String SECRET_JWT = "0785279d-d27a-48d3-8fe9-470740cc366b";

        private final AuthenticationManager authenticationManager;

        public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
            this.authenticationManager = authenticationManager;
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

            try{
                Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
                return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        usuario.getEmail(), usuario.getSenha(), new ArrayList()
                ));
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }


        public static String createToken(Authentication authentication) {
            return JWT.create()
                    .withSubject(authentication.getName())  // Define o 'subject' (usuário)
                    .withClaim("cargo", authentication.getAuthorities().toArray()[0].toString().replace("ROLE_", ""))  // Define o 'cargo' do usuário
                    .withIssuedAt(new Date())  // Data de criação
                    .withExpiresAt(new Date(System.currentTimeMillis() + 60000000))  // Define a data de expiração
                    .sign(Algorithm.HMAC256(SECRET_JWT));  // Assina com a chave secreta
        }
    //    @Override
    //    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException{
    //        UserDetailsCustom userDetailsCustom = (UserDetailsCustom) authResult.getPrincipal();
    //
    //        String role = userDetailsCustom.getAuthorities().stream().findFirst().get().toString();
    //
    //        public static String token = JWT.create()
    //                .withSubject(userDetailsCustom.getUsername())
    //                .withExpiresAt(new Date(System.currentTimeMillis()+6000000))
    //                .withClaim("cargo", role)
    //                .sign(Algorithm.HMAC256(SECRET_JWT));
    //
    //
    //        response.getWriter().write(token);
    //        response.getWriter().flush();
        }
