package projeto.exemplos.config_teste.presentation.rest.contract;

import java.time.LocalDateTime;

public record BookResponse(String id, String title, String author, LocalDateTime createdAt) {
}
