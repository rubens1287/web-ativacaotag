package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import report.Report;
import support.Action;
import support.Verifications;

public class CriarSenhaPage extends DriverManager implements CommonTestingType{

    private By txtCriaSenha = By.id("Senha");
    private By chkTermoAdesao = By.xpath("//label[@for='AceitoTermoDeAdesao']");
    private By btnContinuar = By.className("btn-pagina-senha");

    @Override
    public boolean isPresent() {
        return Verifications.verifyElementIsClickable(txtCriaSenha);
    }

    /**
     * Cria senha e continua
     *
     */
    public void preencheDadosEndereco(){
        Action.setText(txtCriaSenha,"Gft@2020");
        Action.clickOnElement(chkTermoAdesao);
        Report.takeScreenShot();
        DriverManager.getDriver().findElement(btnContinuar).click();
    }


}
