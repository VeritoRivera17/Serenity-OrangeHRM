package com.ejemplo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import java.util.List;

public class AdminUsersPage extends PageObject {

    // Menu "Admin"
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElementFacade adminMenu;

    // Sub-menu "User Management" -> Users (la página que lista usuarios)
    @FindBy(xpath = "//a[contains(@href,'/web/index.php/admin/viewSystemUsers')] | //span[text()='User Management']")
    private WebElementFacade userManagementLink;

    // Campo de búsqueda - Username (puede variar con la versión; ajuste si es necesario)
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElementFacade usernameSearchInput;

    @FindBy(xpath = "//button[.//span[text()='Search'] or @type='submit']")
    private WebElementFacade searchButton;

    // Resultado: fila que contiene el username buscado
    @FindBy(xpath = "//div[@role='row' and .//div[contains(.,'Jasmine.Morgan')]]")
    private WebElementFacade rowWithUser;

    // Botón Edit dentro de la fila (puede variar: usaremos selector relativo)
    @FindBy(xpath = "(//div[@role='row' and .//div[contains(.,'Jasmine.Morgan')]]//button[contains(.,'Edit')])[1]")
    private WebElementFacade editButton;

    // Campo username en el modal/editar
    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    private WebElementFacade usernameEditInput;

    // Botón Save en modal/editar
    @FindBy(xpath = "//button[.//span[text()='Save'] or contains(.,'Save')]")
    private WebElementFacade saveButton;

    // Mensaje de success (toast)
    @FindBy(xpath = "//div[contains(@class,'oxd-toast') and contains(.,'Success')] | //p[contains(.,'Success')]")
    private WebElementFacade successToast;

    public void goToUsersPage() {
        adminMenu.waitUntilClickable().click();
        // Si existe un enlace directo a Users, hacer click
        userManagementLink.waitUntilClickable().click();
    }

    public void searchByUsername(String username) {
        usernameSearchInput.waitUntilVisible().clear();
        usernameSearchInput.type(username);
        searchButton.waitUntilClickable().click();
    }

    public boolean isUserPresentInResults(String username) {
        return element("xpath://div[@role='row' and .//div[contains(.,'" + username + "')]]").isDisplayed();
    }

    public void clickEditForUser(String username) {
        // re-evaluamos la fila dinámicamente
        WebElementFacade edit = element("xpath:(//div[@role='row' and .//div[contains(.,'"+username+"')]]//button[contains(.,'Edit')])[1]");
        edit.waitUntilClickable().click();
    }

    public void updateUsername(String newUsername) {
        usernameEditInput.waitUntilVisible().clear();
        usernameEditInput.type(newUsername);
        saveButton.waitUntilClickable().click();
    }

    public boolean hasSuccessMessage() {
        return successToast.waitUntilVisible().isDisplayed();
    }
}