package seminars.fourth.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Задание 1. Ответьте письменно на вопросы:
 * <p>
 * 1)  Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
 * <p>Тестовые заглушки позволяют подменить вывод/логику вывода методов или значения полей классов, которыми
 * манипулирует тестовый класс, чтобы исключить исполнение логики этих классов, которая не является объектом тестирования
 * <p>
 * 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными
 * аргументами?
 * <p>Mock.mock; Mock.verify(...,Mockito.times(..))
 * <p>
 * 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или
 * исключение в ответ на вызов метода?
 * <p>Mock.mock(); Mock.when().thenReturn; Mock.when().thenThrow()
 * <p>
 * 4) Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?
 * <p> Mock.mock; Mockito.when(database.query(antString())).thenReturn(Arrays.asList("First","Second","Third");
 * <p>
 * Задание 2.
 * <p>
 * У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы
 * данных. Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

  @Mock
  BookRepository bookRepository;

  @InjectMocks
  BookService bookService;

  @Test
  public void findBookByIdInvokedOneTime() {
    bookService.findBookById("1");
    verify(bookRepository, times(1)).findById("1");
  }

  @Test
  public void findBookByIdInvokedTenTimes() {
    IntStream.range(0,10).forEach(element -> bookService.findBookById("1"));
    verify(bookRepository, times(10)).findById("1");
  }
  @Test
  public void findBookByIdNotNullResult() {
    when(bookRepository.findById(anyString())).thenReturn(new Book("testBook"));
    Book testBook = bookService.findBookById("1");
    assertNotEquals(testBook, null);
  }
  @Test
  public void findBookByIdBookReturned() {
    when(bookRepository.findById(anyString())).thenReturn(new Book("testBook"));
    Book testBook = bookService.findBookById("1");
    assertInstanceOf(Book.class, testBook);
  }

  @Test
  public void findAllBooksInvokedOneTime() {
    bookRepository.findAll();
    verify(bookRepository,times(1)).findAll();
  }

  @Test
  public void findAllBooksInvokedTenTimes() {
    IntStream.range(0,10).forEach(element -> bookRepository.findAll());
    verify(bookRepository,times(10)).findAll();
  }

  @Test
  public void findAllNotNullReturned() {
    when(bookRepository.findAll()).thenReturn(List.of(new Book("1"),new Book("2")));
    List<Book> allBooks = bookService.findAllBooks();
    assertNotEquals(allBooks, null);
  }
  @Test
  public void findAllBooksListReturned() {
    when(bookRepository.findAll()).thenReturn(List.of(new Book("1"),new Book("2")));
    List<Book> allBooks = bookService.findAllBooks();
    assertEquals(allBooks.size(),2);
  }
}
