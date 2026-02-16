package projeto.exemplos.config_teste.application.book.usecase.contract;

import java.time.LocalDateTime;

public record SaveNewBookOutput(String id, String title, String author, LocalDateTime createdAt) {
}
