package com.ventoday.bookrepo.mapper;

import com.ventoday.bookrepo.dto.BookDto;
import com.ventoday.bookrepo.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    BookDto entityToDto(BookEntity bookEntity);

    List<BookDto> entitysToDtosList(List<BookEntity> bookEntityList);

    BookEntity dtoToEntity(BookDto bookDto);

    List<BookEntity> dtosToEntityList(BookDto bookDto);

}
