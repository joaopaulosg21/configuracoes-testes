package projeto.exemplos.config_teste.presentation.rest.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.exemplos.config_teste.infra.security.JwtService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest request) {
        String token = jwtService.generateToken(request.username());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/verify")
    public ResponseEntity<Boolean> verifyToken(@RequestParam String token, @RequestParam String username) {
        boolean isValid = jwtService.validateToken(token, username);
        return ResponseEntity.ok(isValid);
    }

    public record AuthRequest(String username) {}
}
