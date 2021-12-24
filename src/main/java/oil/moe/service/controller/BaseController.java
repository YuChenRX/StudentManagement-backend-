package oil.moe.service.controller;

import java.util.List;

public interface BaseController<T> {
    T getById(Long id);

    List<T> getAll();

    boolean add(T t);

    boolean delete(T t);

    boolean deleteById(Long id);
}
