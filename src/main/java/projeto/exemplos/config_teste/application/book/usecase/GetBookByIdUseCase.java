package projeto.exemplos.config_teste.application.book.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import projeto.exemplos.config_teste.application.book.port.BookRepository;
import projeto.exemplos.config_teste.application.book.usecase.contract.SaveNewBookOutput;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetBookByIdUseCase {

    private final BookRepository bookRepository;
    private final CacheManager cacheManager;

    public Optional<SaveNewBookOutput> execute(String id) {
        log.info("Searching for book with id: {}", id);

        Cache bookCache = cacheManager.getCache("books");
        Cache.ValueWrapper cachedBook = bookCache.get(id);

        if (cachedBook != null) {
            log.info("Book with id: {} found in cache", id);
            return Optional.of((SaveNewBookOutput) Objects.requireNonNull(cachedBook.get()));
        }

        log.info("Book with id: {} not found in cache. Searching in repository", id);
        Optional<SaveNewBookOutput> bookFromDb = bookRepository.findById(id)
                .map(book -> new SaveNewBookOutput(book.getId(), book.getTitle(), book.getAuthor(), book.getCreatedAt()));

        bookFromDb.ifPresent(book -> bookCache.put(id, book));

        return bookFromDb;
    }
}
