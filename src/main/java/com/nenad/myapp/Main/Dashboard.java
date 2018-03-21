package com.nenad.myapp.Main;

import com.nenad.myapp.Devices.Devices;
import com.nenad.myapp.History.History;
import com.nenad.myapp.Orders.Orders;
import com.nenad.myapp.Reports.Reports;
import com.nenad.myapp.Stocks.Stocks;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class Dashboard extends VerticalLayout implements View {

    HorizontalLayout upperSection = new HorizontalLayout();
    HorizontalLayout innerUpperSection = new HorizontalLayout();
    HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
    VerticalLayout menuLayout = new VerticalLayout();
    HorizontalLayout menuTitle = new HorizontalLayout();
    VerticalLayout contentLayout = new VerticalLayout();

    Label lblHeader;
    Label lblMenu;
    Button btnLogout;

    public Dashboard(){

        //UI Components

        lblHeader = new Label("myweb");  //will change later
        lblHeader.addStyleNames(ValoTheme.LABEL_COLORED, ValoTheme.LABEL_H2);
        lblHeader.setSizeUndefined();

        btnLogout = new Button("Sign Out");
        btnLogout.addStyleNames(ValoTheme.BUTTON_SMALL, ValoTheme.BUTTON_DANGER);
        btnLogout.setSizeUndefined();
        btnLogout.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                //navigate back to login page
                getUI().getNavigator().navigateTo("login");
            }
        });

        lblMenu = new Label("myweb");
        lblMenu.addStyleNames(ValoTheme.LABEL_COLORED, ValoTheme.LABEL_H2);

        //Sections
        innerUpperSection.addComponent(lblHeader);
        innerUpperSection.addComponent(btnLogout);
        innerUpperSection.setExpandRatio(btnLogout, 1);
        innerUpperSection.setSpacing(true);
        innerUpperSection.setComponentAlignment(btnLogout, Alignment.MIDDLE_RIGHT);

        upperSection.setSizeFull();
        upperSection.addComponent(innerUpperSection);

        upperSection.setMargin(new MarginInfo(false, true, false, false));
        upperSection.setComponentAlignment(innerUpperSection, Alignment.TOP_RIGHT);
        upperSection.addStyleName("borderBottom");
        upperSection.setHeight(4, UNITS_EM);

        //menu section
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);

        lowerSection.addComponent(menuLayout);
        lowerSection.addComponent(contentLayout);
        contentLayout.setSizeFull();
        lowerSection.setSizeFull();
        lowerSection.setSplitPosition(15);

        addComponent(upperSection);
        addComponent(lowerSection);

        setSizeFull();

        setExpandRatio(lowerSection,1);

    }
    public void setMenuTitle() {
        //set the menu title
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);

    }
    public void addWelcomeText() {
        //create new label for welcome text
        Label lblTitle = new Label("Welcome");
        lblTitle.addStyleName("h1");
        lblTitle.addStyleName("colored");

        lblHeader.setValue("");

        contentLayout.addComponent(lblTitle);
        contentLayout.setMargin(new MarginInfo(false, false, false, true));

    }
    public void addDashboardOption(String caption) {
        //set menu buttons

        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();    //remove everything from the content screen section
                addWelcomeText();
            }

        });
    }
    public Component getComponent(String componentName) {
        if (componentName.equals("Devices")) {
            return new Devices();
        } else if (componentName.equals("History")) {
            return new History();
        } else if (componentName.equals("Stocks")) {
            return new Stocks();
        }else if (componentName.equals("Orders")) {
            return new Orders();
        }else { //reports
            return new Reports();
        }
    }
    public void addMenuOption(String caption, String componentName) {
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                contentLayout.removeAllComponents();
                contentLayout.addComponent(getComponent(componentName));
            }
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //reset screen
        menuLayout.removeAllComponents();
        contentLayout.removeAllComponents();

        //add components
        setMenuTitle();
        this.addDashboardOption("Dashboard");

        this.addMenuOption("Devices", "Devices");
        this.addMenuOption("History", "History");
        this.addMenuOption("Stocks", "Stocks");

        this.addMenuOption("Orders", "Orders");
        this.addMenuOption("Reports", "Reports");

        addWelcomeText();
    }
}
