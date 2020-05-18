package pages;

import core.azure.model.attachment.Attachment;
import core.driver.DriverManager;
import org.openqa.selenium.By;
import core.strings.StringUtils;
import support.Action;
import support.Verifications;

import java.util.HashMap;

public class DocumentosBasicoPage extends DriverManager implements CommonTestingType {


    private By txtCpf = By.id("CPF2");
    private By txtNome = By.id("Nome2");
    private By txtEmail = By.id("Email2");
    private By txtCelular = By.id("Celular2");
    private By btnVamosComecar = By.xpath("//button[contains(text(),'Vamos começar')]");

    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(txtNome)
                &&  Verifications.verifyElementIsClickable(txtEmail)
                &&  Verifications.verifyElementIsClickable(txtCelular)
                && Verifications.verifyElementExists(btnVamosComecar);
    }

    /**
     * Preenche os dados basico do cliente
     *
     */
    public void preencheDadosBasicos(HashMap data){
        String nome = faker.name().fullName();
        Action.setText(txtNome,nome);
        Action.setText(txtEmail, StringUtils.unaccent(nome+"@gmail.com"));
        Action.setText(txtCelular,data.get("cel"));
        attachments.add(new Attachment());
        Action.clickOnElement(btnVamosComecar);
    }


}
