package pages;

import core.azure.model.attachment.Attachment;
import core.driver.DriverManager;
import org.openqa.selenium.By;
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
        attachments.add(new Attachment());
        Action.clickOnElement(By.xpath("//li[@id='"+data.get("plano")+"']//button"));
    }


}
