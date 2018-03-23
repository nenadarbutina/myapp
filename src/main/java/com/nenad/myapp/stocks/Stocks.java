package com.nenad.myapp.stocks;

import com.nenad.myapp.main.PrivateUI;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Nenad on 19.3.2018..
 */
@SpringView(name = "stocks", ui = PrivateUI.class)
public class Stocks extends VerticalLayout implements View {
}
