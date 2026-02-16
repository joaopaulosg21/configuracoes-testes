package projeto.exemplos.config_teste.infra.repository;

import org.springframework.stereotype.Repository;
import projeto.exemplos.config_teste.application.book.domain.Book;
import projeto.exemplos.config_teste.application.book.port.BookRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final Map<String, Book> inMemoryDatabase = new HashMap<>();

    @Override
    public Book save(Book book) {
        inMemoryDatabase.put(book.getId(), book);
        return book;
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(inMemoryDatabase.get(id));
    }
}
