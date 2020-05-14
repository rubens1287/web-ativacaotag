package pages;

import azure.model.attachment.Attachment;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import support.Action;
import support.Verifications;

public class DocumentosPessoaisPage extends DriverManager implements CommonTestingType {


    private By txtRg = By.id("RG");
    private By txtDataNascimento = By.id("DataNascimento");
    private By cbbGenero = By.id("Genero");
    private By txtNomeMae = By.id("NomeMae");


    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(txtRg)
                &&  Verifications.verifyElementIsClickable(txtDataNascimento)
                &&  Verifications.verifyElementIsClickable(cbbGenero)
                && Verifications.verifyElementExists(txtNomeMae);
    }

    /**
     * Preenche os dados pessoais do cliente
     *
     */
    public void preencheDadosPessoais(){
        Action.setText(txtRg,faker.idNumber().valid());
        Action.setText(txtDataNascimento, "24/12/1982");
        Action.selectComboOptionByValue(cbbGenero,"Masculino");
        Action.setText(txtNomeMae,faker.name().fullName());
        attachments.add(new Attachment());
        Action.clickOnElement(txtRg);
        getDriver().findElement(txtRg).sendKeys(Keys.ENTER);
    }


}
