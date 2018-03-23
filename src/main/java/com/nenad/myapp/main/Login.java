package com.nenad.myapp.main;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Nenad on 19.3.2018..
 */
@SpringView(name = "", ui = PublicUI.class)
public class Login extends VerticalLayout implements View {

    public Login(SpringNavigator navigator) {
        Label header = new Label("PCSweb");
        header.addStyleNames(ValoTheme.LABEL_COLORED);

        TextField txtusername = new TextField("Username");
        PasswordField txtpassword = new PasswordField("Password");
        txtusername.addStyleNames(ValoTheme.TEXTFIELD_TINY);
        txtpassword.addStyleNames(ValoTheme.TEXTFIELD_TINY);

        Button btnlogin = new Button("Login", e -> Notification.show("Logged in"));
        btnlogin.addStyleNames(ValoTheme.BUTTON_FRIENDLY, ValoTheme.BUTTON_TINY);
        btnlogin.setIcon(VaadinIcons.SIGN_IN);
        btnlogin.addClickListener(e -> loginClicked());

        FormLayout formLayout = new FormLayout(header, txtusername, txtpassword, btnlogin);
        formLayout.setMargin(true);
        Panel panel = new Panel("Login", formLayout);
        panel.setWidth("450");
        panel.setHeight("300");

        addComponents(panel);
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        setHeight("100%");
    }

    private void loginClicked() {
        Page.getCurrent().setLocation("dashboard");
    }

}
