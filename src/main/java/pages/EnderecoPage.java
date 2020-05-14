package pages;

import azure.model.attachment.Attachment;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import support.Action;
import support.Verifications;

public class EnderecoPage extends DriverManager implements CommonTestingType {

    private By txtCep = By.id("CEP");
    private By txtNumero = By.id("NumeroEndereco");


    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(txtCep);
    }

    /**
     * Preenche os dados de endereço residencial
     *
     */
    public void preencheDadosEndereco(){
        Action.setText(txtCep,"05873-260");
        getDriver().findElement(txtCep).sendKeys(Keys.ENTER);
        Action.setText(txtNumero,"10");
        attachments.add(new Attachment());
        getDriver().findElement(txtCep).sendKeys(Keys.ENTER);
    }
}
