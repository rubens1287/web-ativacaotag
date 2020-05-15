package pages;

import core.azure.model.attachment.Attachment;
import core.driver.DriverManager;
import model.TagModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import support.Verifications;
import support.VerificationsJavaScript;

import java.util.HashMap;

public class ValidaDadosAtivacaoPage extends DriverManager implements CommonTestingType {

    private By txtNumeroAdesivo = By.id("Adesivo-Confirmacao");
    private By txtPlaca = By.id("Placa-Confirmacao");

    @Override
    public boolean isPresent() {
        return Verifications.verifyElementIsClickable(txtNumeroAdesivo)
                && Verifications.verifyElementExists(txtPlaca);
    }

    /**
     * Confirma se tag id e placa do veiculo está certa
     *
     */
    public boolean isValidaDados(HashMap data){
        return  VerificationsJavaScript.verifyText("Adesivo-Confirmacao", TagModel.getTagId())
                && VerificationsJavaScript.verifyText("Placa-Confirmacao",data.get("placa"));
    }

    /**
     * Clica no botão continuar
     *
     */
    public void continua(){
        attachments.add(new Attachment());
        getDriver().findElement(txtNumeroAdesivo).sendKeys(Keys.ENTER);
    }

}
