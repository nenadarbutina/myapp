package com.nenad.myapp.main;

import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;

/**
 * @author Alejandro Duarte
 */
@SpringUI(path = "dashboard")
@PushStateNavigation
public class PrivateUI extends UI {

    private final SpringNavigator navigator;
    private final Dashboard dashboard;

    public PrivateUI(SpringNavigator navigator, Dashboard dashboard) {
        this.navigator = navigator;
        this.dashboard = dashboard;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(dashboard);
        navigator.init(getUI(), dashboard.getContentLayout());
    }

}
