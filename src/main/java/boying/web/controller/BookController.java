package boying.web.controller;

import boying.dao.book.BookDao;
import boying.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by boying on 2017/7/21.
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("hello")
    public String hello(){
        Book book = bookDao.getBookById(1L);
        //return book.getName();
        return book.toString();
    }

}
