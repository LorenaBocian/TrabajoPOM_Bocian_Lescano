package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Eminent extends ClaseBase {

    public Eminent(WebDriver driver) {super(driver);}

    By locatorBtnEspMasCercano = By.xpath("//a[@id='p-1']");
    By locatorPopUp = By.xpath("/html[1]/body[1]/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]");

    public void buscarEspacioCercano(){
        click(esperarPorElementoAClickear(locatorBtnEspMasCercano));
    }

    public String obtenerPoUp(){
        return obtenerTexto(locatorPopUp);
    }
}
