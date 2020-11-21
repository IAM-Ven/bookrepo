package com.ventoday.bookrepo.service;

import com.ventoday.bookrepo.dto.BookDto;
import com.ventoday.bookrepo.entity.BookEntity;
import com.ventoday.bookrepo.mapper.BookMapper;
import com.ventoday.bookrepo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    private BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookMapper.entitysToDtosList(bookEntities);

    }

    public BookDto createBook(BookDto bookDto) {
        BookEntity newBook = bookMapper.dtoToEntity(bookDto);
        return bookMapper.entityToDto(bookRepository.save(newBook));
    }

    public BookDto getBookById(long id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if (bookEntity.isPresent()) {
            return bookMapper.entityToDto(bookEntity.get());
        }
        return null;
    }

    public BookDto updateBookById(long id, BookDto bookDto) {

        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if (bookEntity.isPresent()) {
            bookEntity.get().setAuthor(bookDto.getAuthor());
            bookEntity.get().setCategory(bookDto.getCategory());
            bookEntity.get().setName(bookDto.getName());
            bookEntity.get().setPrice(bookDto.getPrice());
            bookEntity.get().setQuantity(bookDto.getQuantity());

        }
        BookEntity updatedBookEntity = bookRepository.save(bookEntity.get());
        BookDto updatedBookDto = bookMapper.entityToDto(updatedBookEntity);
        return updatedBookDto;
    }

    public BookDto deleteBookById(long id) {
        Optional<BookEntity> bookEntity = bookRepository.findById(id);
        if (!bookEntity.isPresent()) {
            System.out.println("Book Id could not be found");
        }
        return bookMapper.entityToDto(bookEntity.get());
    }

    BookEntity bookEntity = BookEntity.builder().id(12).build();
    BookEntity bookEntity1 = new BookEntity();
    bookEntity1.
}
