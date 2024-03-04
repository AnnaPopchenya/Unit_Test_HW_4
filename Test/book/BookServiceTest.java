package book;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Test
    public void testFindBookById() {
        // Создаем мок-объект BookRepository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        // Устанавливаем поведение мок-объекта
        Book expectedBook = new Book("1", "Title", "Author");
        when(bookRepository.findById("1")).thenReturn(expectedBook);

        // Вызываем метод findBookById и проверяем результат
        Book actualBook = bookService.findBookById("1");
        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testFindAllBooks() {
        // Создаем мок-объект BookRepository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        // Устанавливаем поведение мок-объекта
        List<Book> expectedBooks = Arrays.asList(
                new Book("1", "Title1", "Author1"),
                new Book("2", "Title2", "Author2")
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Вызываем метод findAllBooks и проверяем результат
        List<Book> actualBooks = bookService.findAllBooks();
        assertEquals(expectedBooks, actualBooks);
    }
}