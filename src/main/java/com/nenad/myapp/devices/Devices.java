package com.nenad.myapp.devices;

import com.nenad.myapp.main.PrivateUI;
import com.vaadin.navigator.View;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import java.util.Map;
import java.util.stream.Collectors;

@SpringView(name = "devices", ui = PrivateUI.class)
public class Devices extends VerticalLayout implements View {

    private Grid<Web> grid;

    public Devices(WebService webService) {
        setSizeFull();
        grid = new Grid<>(Web.class);
        grid.setSizeFull();

        grid.setDataProvider(
                (sortOrders, offset, limit) -> {
                    Map<String, Boolean> sortOrder = sortOrders.stream()
                            .collect(Collectors.toMap(
                                    sort -> sort.getSorted(),
                                    sort -> sort.getDirection() == SortDirection.ASCENDING));

                    return webService.findAll(offset, limit, sortOrder).stream();
                },
                () -> webService.count()
        );

        addComponent(grid);
        setExpandRatio(grid, 1);
    }

}
