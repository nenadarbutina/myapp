package com.nenad.myapp.history;

import com.nenad.myapp.main.PrivateUI;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Nenad on 19.3.2018..
 */
@SpringView(name = "history", ui = PrivateUI.class)
public class History extends VerticalLayout implements View {
}
