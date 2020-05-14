package pages;

import azure.model.attachment.Attachment;
import driver.DriverManager;
import org.openqa.selenium.By;
import support.Action;
import support.Verifications;

public class CriarSenhaPage extends DriverManager implements CommonTestingType {

    private By txtCriaSenha = By.id("Senha");
    private By chkTermoAdesao = By.xpath("//label[@for='AceitoTermoDeAdesao']");
    private By btnContinuar = By.className("btn-pagina-senha");

    private By msgErro = By.xpath("//div[contains(@data-bind,'StepSenha')]//div/p[contains(text(),'por favor tente novamente mais tarde')]");

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
        attachments.add(new Attachment());
        DriverManager.getDriver().findElement(btnContinuar).click();
    }

    public boolean isMensagemErroShow(){
        boolean value = Verifications.verifyElementIsClickable(msgErro);
        return value;
    }


}
