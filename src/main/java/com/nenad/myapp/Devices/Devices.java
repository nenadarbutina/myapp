package com.nenad.myapp.Devices;

import com.vaadin.navigator.View;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import java.util.Map;
import java.util.stream.Collectors;


public class Devices extends VerticalLayout implements View {


    private Web_Service service;

    private Grid<web> grid;


    public Devices(Web_Service service) {
        this.service = service;
    }

        public Devices() {


        setSizeFull();
        grid = new Grid<>(web.class);
        grid.setSizeFull();

        grid.setDataProvider(
                (sortOrders, offset, limit) -> {
                    Map<String, Boolean> sortOrder = sortOrders.stream()
                            .collect(Collectors.toMap(
                                    sort -> sort.getSorted(),
                                    sort -> sort.getDirection() == SortDirection.ASCENDING));

                    return service.findAll(offset, limit, sortOrder).stream();
                },
                () -> service.count()
        );

        addComponent(grid);
        setExpandRatio(grid, 1);

    }

}
