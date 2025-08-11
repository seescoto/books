package com.books.springboot;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    public BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book", "id", id));
    }

    @Override
    public Book updateBook(Book book, long id) {
        Book oldBook = this.getBookById(id);

        oldBook.setAuthor(book.getAuthor());
        oldBook.setTitle(book.getTitle());

        bookRepository.save(oldBook);

        return oldBook;
    }

    @Override
    public void deleteBook(long id) {
        // ensure that book exists first
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book", "id", id));

        bookRepository.deleteById(id);
    }

}
