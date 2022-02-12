package by.staravoyt.app.dto.convertors;

import java.util.List;
import java.util.stream.Collectors;

import by.staravoyt.app.dto.AbstractDto;
import by.staravoyt.app.models.EntityModel;


public interface ModelDtoConvertor<T extends EntityModel, R extends AbstractDto> {
    R convert(T t);

    default List<R> convert(List<T> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
