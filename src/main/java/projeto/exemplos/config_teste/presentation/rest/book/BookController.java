package projeto.exemplos.config_teste.presentation.rest.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.exemplos.config_teste.application.book.usecase.GetBookByIdUseCase;
import projeto.exemplos.config_teste.application.book.usecase.SaveNewBookUseCase;
import projeto.exemplos.config_teste.application.book.usecase.contract.SaveNewBookInput;
import projeto.exemplos.config_teste.presentation.rest.contract.BookResponse;
import projeto.exemplos.config_teste.presentation.rest.contract.CreateBookRequest;

import java.net.URI;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final SaveNewBookUseCase saveNewBookUseCase;
    private final GetBookByIdUseCase getBookByIdUseCase;

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookRequest request) {
        log.info("Creating book with title: {}", request.getTitle());
        var input = new SaveNewBookInput(request.getTitle(), request.getAuthor());
        var output = saveNewBookUseCase.execute(input);
        var response = new BookResponse(output.id(), output.title(), output.author(), output.createdAt());
        log.info("Book created with id: {}", response.id());
        return ResponseEntity.created(URI.create("/books/" + response.id())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {
        log.info("Searching for book with id: {}", id);
        return getBookByIdUseCase.execute(id)
                .map(output -> new BookResponse(output.id(), output.title(), output.author(), output.createdAt()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
