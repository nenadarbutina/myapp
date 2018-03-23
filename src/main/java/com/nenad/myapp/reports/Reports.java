package com.nenad.myapp.reports;

import com.nenad.myapp.main.PrivateUI;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Nenad on 19.3.2018..
 */
@SpringView(name = "reports", ui = PrivateUI.class)
public class Reports extends VerticalLayout implements View {
}
