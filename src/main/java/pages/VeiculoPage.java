package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import report.Report;
import support.Action;
import support.Verifications;
import support.VerificationsJavaScript;

import java.util.HashMap;

public class VeiculoPage extends DriverManager implements CommonTestingType {


    private By txtPlaca = By.id("Placa");

    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(txtPlaca);
    }

    /**
     * Preenche os dados do veiculo
     *
     */
    public void preencherDados(HashMap data){
        Action.setText(txtPlaca,data.get("placa"));
        Report.takeScreenShot();
        VerificationsJavaScript.verifyText("VeiculoMarca", data.get("marca"));
        getDriver().findElement(txtPlaca).sendKeys(Keys.ENTER);
    }

}
