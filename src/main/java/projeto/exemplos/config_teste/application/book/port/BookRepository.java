package projeto.exemplos.config_teste.application.book.port;

import projeto.exemplos.config_teste.application.book.domain.Book;

import java.util.Optional;

public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(String id);
}
