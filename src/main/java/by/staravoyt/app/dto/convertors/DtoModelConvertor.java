package by.staravoyt.app.dto.convertors;

import java.util.List;
import java.util.stream.Collectors;

import by.staravoyt.app.dto.AbstractDto;
import by.staravoyt.app.models.EntityModel;


public interface DtoModelConvertor<T extends AbstractDto, R extends EntityModel> {
    R convert(T t);

    default List<R> covert(List<T> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
