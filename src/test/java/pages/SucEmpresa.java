package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class SucEmpresa extends ClaseBase {

    public SucEmpresa(WebDriver driver) {super(driver);}

    By locatorMensajeEmpresa = By.xpath("//body[1]/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/h1[1]");

    public String obtenerMensaje(){
        return obtenerTexto(locatorMensajeEmpresa);
    }
}
