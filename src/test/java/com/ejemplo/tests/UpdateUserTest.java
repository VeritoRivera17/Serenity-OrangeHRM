package com.ejemplo.tests;

import com.ejemplo.util.TestBase;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
//import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.ManagedPages;
import net.serenitybdd.annotations.Managed;

import static org.assertj.core.api.Assertions.assertThat;

import com.ejemplo.pages.LoginPage;
import com.ejemplo.pages.AdminUsersPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class UpdateUserTest extends TestBase {

    @Managed(driver = "chrome")
    WebDriver driver;

    LoginPage loginPage;
    AdminUsersPage adminUsersPage;

    @Test
    public void should_update_username_for_jasmine_morgan_and_show_success() {
        // Datos de prueba - según el enunciado
        String loginUser = "Admin";
        String loginPass = "admin123";
        String targetUser = "Jasmine.Morgan";
        String newUsername = "Jasmine.Morgan.Test";

        // 1. Abrir login y autenticarse
        loginPage.open();
        loginPage.loginAs(loginUser, loginPass);

        // 2. Ir a Admin -> Users
        adminUsersPage.goToUsersPage();

        // 3. Buscar al usuario
        adminUsersPage.searchByUsername(targetUser);
        boolean present = adminUsersPage.isUserPresentInResults(targetUser);
        assertThat(present).as("Usuario debe aparecer en la lista").isTrue();

        // 4. Editar y guardar nuevo username
        adminUsersPage.clickEditForUser(targetUser);
        adminUsersPage.updateUsername(newUsername);

        // 5. Validar mensaje de éxito
        assertThat(adminUsersPage.hasSuccessMessage()).isTrue();
    }
}