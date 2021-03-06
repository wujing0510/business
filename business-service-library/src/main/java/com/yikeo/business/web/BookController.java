package com.yikeo.business.web;

import com.yikeo.business.entity.Book;
import com.yikeo.business.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuJing
 * @version 0.1
 * @since 2019-06-27
 */

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;


    @RequestMapping("/findById")
    public Book findById(@RequestParam("id") Long id) {
        Book book = bookService.findById(id);
        return book;
    }

    @RequestMapping("/findByTitle")
    public List<Book> findByTitle(@RequestParam("title") String title) {
        List<Book> books = bookService.findByTitle(title);
        return books;
    }

    @RequestMapping("/findByIds")
    public List<Book> findByIds(@RequestParam("ids") String ids) {

        Assert.hasText(ids, "params[ids] cannot be empty!");

        String[] idArray = ids.split(",");

        List<Long> idList = new ArrayList();

        for (String sid: idArray) {
            idList.add(Long.parseLong(sid));
        }
        return null;
    }
}
