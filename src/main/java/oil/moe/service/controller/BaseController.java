package oil.moe.service.controller;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BaseController<T> {
    T getById(Long id);

    List<T> getAll(int beginPage,int endPage);

    T add(T t);


    T deleteById(Long id);

    T modify(T t, @PathVariable Long id);
}
