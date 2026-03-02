package unternehmensstruktur.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;

@Layout
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        DrawerToggle drawerToggle = new DrawerToggle();

        H1 title = new H1("Unternehmensstruktur");
        title.addClassName("h1-custom");

        SideNav nav = getSideNav();
        Scroller scroller = new Scroller(nav);

        addToDrawer(scroller);
        addToNavbar(drawerToggle, title);
    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addClassName("sidebar-custom");

        nav.addItem(new SideNavItem("Mitarbeiter",            "/mitarbeiter",            VaadinIcon.USER.create()));
        nav.addItem(new SideNavItem("Firmen",                 "/firmen",                 VaadinIcon.OFFICE.create()));
        nav.addItem(new SideNavItem("Standorte",              "/standorte",              VaadinIcon.BUILDING.create()));
        nav.addItem(new SideNavItem("Adressen",               "/adressen",               VaadinIcon.HOME.create()));
        nav.addItem(new SideNavItem("Organisationseinheiten", "/organisationseinheiten", VaadinIcon.GROUP.create()));
        nav.addItem(new SideNavItem("Mitglieder",             "/mitglieder",             VaadinIcon.USERS.create()));
        nav.addItem(new SideNavItem("Kunden",                 "/kunden",                 VaadinIcon.USER_CARD.create()));
        nav.addItem(new SideNavItem("IT Assets",              "/it-assets",              VaadinIcon.SERVER.create()));
        nav.addItem(new SideNavItem("IT Systeme",             "/it-systeme",             VaadinIcon.LAPTOP.create()));
        nav.addItem(new SideNavItem("Projekte",               "/projekte",               VaadinIcon.CLIPBOARD.create()));
        nav.addItem(new SideNavItem("Abh\u00e4ngigkeiten",     "/abhaengigkeiten",        VaadinIcon.CONNECT.create()));
        nav.addItem(new SideNavItem("Telekom Shops",          "/telekom-shops",          VaadinIcon.SHOP.create()));
        nav.addItem(new SideNavItem("B\u00fcrogeb\u00e4ude",   "/buerogebaeude",          VaadinIcon.FACTORY.create()));
        nav.addItem(new SideNavItem("Arbeitspl\u00e4tze",      "/arbeitsplaetze",         VaadinIcon.DESKTOP.create()));
        nav.addItem(new SideNavItem("Schreibtische",          "/schreibtische",          VaadinIcon.DESKTOP.create()));
        nav.addItem(new SideNavItem("Meetingr\u00e4ume",       "/meetingraeume",          VaadinIcon.PRESENTATION.create()));
        nav.addItem(new SideNavItem("Buchungen",              "/buchungen",              VaadinIcon.CALENDAR.create()));

        nav.getItems().forEach(navItem -> navItem.setMatchNested(true));
        return nav;
    }
}
