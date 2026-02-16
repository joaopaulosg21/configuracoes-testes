package projeto.exemplos.config_teste.presentation.rest.contract;

import lombok.Data;

@Data
public class CreateBookRequest {
    private String title;
    private String author;
}
