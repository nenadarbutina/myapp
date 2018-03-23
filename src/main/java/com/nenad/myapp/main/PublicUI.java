package com.nenad.myapp.main;

import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;

@SpringUI
@PushStateNavigation
public class PublicUI extends UI {

    private final SpringNavigator navigator;

    public PublicUI(SpringNavigator navigator) {
        this.navigator = navigator;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator.init(this, this);
    }

}
