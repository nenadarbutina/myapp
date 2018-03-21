package com.nenad.myapp.Main;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Nenad on 19.3.2018..
 */
public class Login extends VerticalLayout implements View {

    Label header;
    TextField txtusername;
    PasswordField txtpassword;
    Button btnlogin;

    public Login(){

        header = new Label("PCSweb");
        header.addStyleNames(ValoTheme.LABEL_COLORED);
        txtusername = new TextField("Username");
        txtpassword = new PasswordField("Password");
        txtusername.addStyleNames(ValoTheme.TEXTFIELD_TINY);
        txtpassword.addStyleNames(ValoTheme.TEXTFIELD_TINY);
        btnlogin = new Button("Login",e -> Notification.show("Logged in"));
        btnlogin.addStyleNames(ValoTheme.BUTTON_FRIENDLY, ValoTheme.BUTTON_TINY);
        btnlogin.setIcon(VaadinIcons.SIGN_IN);

        btnlogin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                //logged in successfully
                getUI().getNavigator().navigateTo("dashboard");

                //reset UI Components
                txtusername.setValue("");
                txtpassword.setValue("");
            }
        });


        FormLayout formLayout = new FormLayout(header, txtusername, txtpassword, btnlogin);
        formLayout.setMargin(true);
        Panel panel = new Panel("Login", formLayout);
        panel.setWidth("450");
        panel.setHeight("300");

        addComponents(panel);
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        setHeight("100%");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
