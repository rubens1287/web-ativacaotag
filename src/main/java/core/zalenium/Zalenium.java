package core.zalenium;

import core.driver.DriverManager;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import support.Verifications;

import static io.restassured.RestAssured.given;


@Log4j2
public class Zalenium extends DriverManager {


    public static void waitToBeReady(String url){

        RequestSpecification httpRequest = given();
        int timeout = 0;
        while (httpRequest.get(url+"/status").getStatusCode() != 200 && timeout <= configuration.timeout()) {
            Verifications.wait(1);
            log.info("Aguardando o servidor do zalenium estar pronto para execução");
            if (timeout == configuration.timeout()) {
                log.error("Excedeu o time-out para disponibilizar o servidor do zalenium");
            }
            timeout++;
        }
    }
}
