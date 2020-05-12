package pages;

import documents.Documents;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import model.TagModel;
import org.openqa.selenium.By;
import report.Report;
import support.Action;
import support.Verifications;

import java.util.HashMap;

@Log4j2
public class AtivacaoTagPage extends DriverManager implements CommonTestingType {

    private By txtCpf = By.name("CPF");
    private By txtAdesivo = By.name("Adesivo");
    private By btnAtivar = By.xpath("//button[contains(text(),'Ative já seu ConectCar')]");

    public void acessarPagina(){
        getDriver().get(configuration.url());
    }

    @Override
    public boolean isPresent() {
        return Verifications.waitPageLoad()
                && Verifications.verifyElementIsClickable(txtCpf)
                && Verifications.verifyElementIsClickable(txtAdesivo)
                && Verifications.verifyElementExists(btnAtivar);
    }

    public void preencheDadosAtivacao(HashMap data){
        Documents documents = new Documents();

        TagModel tagModel = new TagModel();
        TagModel.setTagId(tagModel.selectTagId());

        String cpf = documents.getCpf(true);
        Report.appendInfo("Numero do CPF: "+cpf);
        Action.setText(txtCpf, cpf);
        Action.setText(txtAdesivo,TagModel.getTagId());
        Report.takeScreenShot();
        Action.clickOnElement(btnAtivar);
    }

}
