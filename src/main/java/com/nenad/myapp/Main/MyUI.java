package com.nenad.myapp.Main;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Navigator navigator = new Navigator(this, this);

        navigator.addView("login", new Login());
        navigator.addView("dashboard", new Dashboard());

        navigator.navigateTo("login");

    }
}
