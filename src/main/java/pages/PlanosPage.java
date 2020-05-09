package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import report.Report;
import strings.StringUtils;
import support.Action;
import support.Verifications;

import java.util.HashMap;

public class PlanosPage extends DriverManager implements CommonTestingType{


    private By btnPlano = By.className("planos-ativacao");

    @Override
    public boolean isPresent() {
        return  Verifications.verifyElementIsClickable(btnPlano);
    }

    /**
     * Escolhe o plano do cliente
     *
     */
    public void escolherPlano(HashMap data){
        Report.takeScreenShot();
        Action.clickOnElement(By.xpath("//li[@id='"+data.get("plano")+"']//button"));
    }


}
