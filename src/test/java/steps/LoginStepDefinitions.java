package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import pages.HomePage;
import pages.LoginPage;
import pages.LoginPasswordPage;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    LoginPasswordPage loginPasswordPage = new LoginPasswordPage();
    HomePage homePage = new HomePage();

    @Dado("^que estou na tela de login do Mantis$")
    public void que_estou_na_tela_de_login_do_Mantis() {
         loginPage.getPage();
         loginPage.checkLoginPage();
    }

    @Dado("^que estou logado no Mantis$")
    public void que_estou_logado_no_Mantis() {
        loginPage.fillUserField();
        loginPage.clickEntrar();
        loginPasswordPage.fillPasswordField();
        loginPasswordPage.clickEntrar();
        homePage.checkTitle();
    }

    @Quando("^preencho login válido$")
    public void preencho_login_válido() {
         loginPage.fillUserField();
         loginPage.clickEntrar();
    }

    @Quando("^preencho a senha válida$")
    public void preencho_a_senha_válida() {
         loginPasswordPage.fillPasswordField();
         loginPage.clickEntrar();
    }

    @Quando("^preencho uma senha incorreta$")
    public void preencho_uma_senha_incorreta() {
        loginPasswordPage.fillInvalidPassword();
        loginPasswordPage.clickEntrar();
    }

    @Quando("^clico no botão Entrar da página de login$")
    public void clico_no_botão_Entrar_da_página_de_login() {
        loginPage.clickEntrar();
    }

    @Quando("^clico em Sair$")
    public void clico_em_Sair() throws Exception {
        homePage.clickSair();
    }

    @Então("^devo visualizar uma mensagem de erro \"([^\"]*)\"$")
    public void devo_visualizar_uma_mensagem_de_erro(String value) {
        loginPage.checkAlertMessage(value);
    }

    @Então("^a tela inicial deverá ser apresentada$")
    public void a_tela_inicial_deverá_ser_apresentada() {
       homePage.checkPage();
    }

    @Então("^devo ser redirecionado para a tela de login$")
    public void devo_ser_redirecionado_para_a_tela_de_login() throws Exception {
        loginPage.checkLoginPage();
    }
}
