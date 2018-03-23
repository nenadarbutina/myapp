package com.nenad.myapp.devices;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class WebService {

    private final WebRepository repository;

    public WebService(WebRepository repository) {
        this.repository = repository;
    }

    public List<Web> findAll(int offset, int limit, Map<String, Boolean> sortOrders) {
        int page = offset / limit;
        List<Sort.Order> orders = sortOrders.entrySet().stream()
                .map(e -> new Sort.Order(e.getValue() ? Sort.Direction.ASC : Sort.Direction.DESC, e.getKey()))
                .collect(Collectors.toList());

        PageRequest pageRequest = PageRequest.of(page, limit, Sort.by(orders));
        List<Web> items = repository.findAll(pageRequest).getContent();
        return items.subList(offset % limit, items.size());
    }

    public Integer count() {
        return Math.toIntExact(repository.count());
    }

}
