package com.nenad.myapp.main;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

/**
 * @author Alejandro Duarte
 */
@SpringView(name = "", ui = PrivateUI.class)
public class Welcome extends Composite implements View {

    public Welcome() {
        Label title = new Label("Welcome");
        title.addStyleName("h1");
        title.addStyleName("colored");
        setCompositionRoot(title);
    }

}
