package boying.service.book;

import boying.dao.book.BookDao;
import boying.domain.book.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by boying on 2017/7/4.
 */
@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookDao bookDao;

    public Book getBookById(long id) {
        System.out.println(this.hashCode());
        logger.info("BookService.getBookById into");
        Book ret = bookDao.getBookById(id);
        logger.info("BookService.getBookById done, ret is {}", ret);
        return ret;
    }

    @Transactional("bookTransactionManager")
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Transactional("bookTransactionManager")
    public void deleteBook(long id) {
        bookDao.deleteBook(id);
    }

    @Transactional("bookTransactionManager")
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public List<Book> fuzzyQueryBooksByName(String name) {
        return Optional.ofNullable(bookDao.fuzzyQueryBooksByName(name)).orElse(Collections.emptyList());
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    /**
     * Mockito会调用setter设置mocker
     * 详见 boying.service.book.BookServiceMockTest
     */
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookService self(){
        return this;
    }
}
