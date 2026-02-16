package projeto.exemplos.config_teste.application.book.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projeto.exemplos.config_teste.application.book.domain.Book;
import projeto.exemplos.config_teste.application.book.port.BookRepository;
import projeto.exemplos.config_teste.application.book.usecase.contract.SaveNewBookInput;
import projeto.exemplos.config_teste.application.book.usecase.contract.SaveNewBookOutput;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveNewBookUseCase {

    private final BookRepository bookRepository;

    public SaveNewBookOutput execute(SaveNewBookInput input) {
        Book newBook = new Book(input.title(), input.author());
        Book savedBook = bookRepository.save(newBook);
        return new SaveNewBookOutput(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getCreatedAt());
    }
}
