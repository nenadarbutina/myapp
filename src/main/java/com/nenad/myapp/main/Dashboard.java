package com.nenad.myapp.main;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
public class Dashboard extends VerticalLayout {

    private HorizontalLayout upperSection = new HorizontalLayout();
    private HorizontalLayout innerUpperSection = new HorizontalLayout();
    private HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
    private VerticalLayout menuLayout = new VerticalLayout();
    private HorizontalLayout menuTitle = new HorizontalLayout();
    private VerticalLayout contentLayout = new VerticalLayout();

    private Label lblHeader;
    private Label lblMenu;
    private Button btnLogout;

    public Dashboard() {
        //UI Components

        lblHeader = new Label("myweb");  //will change later
        lblHeader.addStyleNames(ValoTheme.LABEL_COLORED, ValoTheme.LABEL_H2);
        lblHeader.setSizeUndefined();

        btnLogout = new Button("Sign Out");
        btnLogout.addStyleNames(ValoTheme.BUTTON_SMALL, ValoTheme.BUTTON_DANGER);
        btnLogout.setSizeUndefined();
        btnLogout.addClickListener((Button.ClickListener) e -> getUI().getNavigator().navigateTo("login"));

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
        setExpandRatio(lowerSection, 1);
    }


    public void setMenuTitle() {
        //set the menu title
        menuTitle.addComponent(lblMenu);
        menuLayout.addComponent(menuTitle);
        menuLayout.setWidth("100%");
        menuLayout.setComponentAlignment(menuTitle, Alignment.MIDDLE_CENTER);
    }

    public void addDashboardOption(String caption) {
        //set menu buttons

        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);

        button.addClickListener((Button.ClickListener) event -> {
            getUI().getNavigator().navigateTo("");
        });
    }

    public void addMenuOption(String caption, String viewName) {
        Button button = new Button(caption);
        button.setWidth("100%");
        button.setStyleName("borderless");
        menuLayout.addComponent(button);
        button.addClickListener(e -> UI.getCurrent().getNavigator().navigateTo(viewName));
    }

    @Override
    public void attach() {
        super.attach();

        //reset screen
        menuLayout.removeAllComponents();

        //add components
        setMenuTitle();
        this.addDashboardOption("Dashboard");

        this.addMenuOption("Devices", "devices");
        this.addMenuOption("History", "history");
        this.addMenuOption("Stocks", "stocks");

        this.addMenuOption("Orders", "orders");
        this.addMenuOption("Reports", "reports");
    }

    public VerticalLayout getContentLayout() {
        return contentLayout;
    }

}
