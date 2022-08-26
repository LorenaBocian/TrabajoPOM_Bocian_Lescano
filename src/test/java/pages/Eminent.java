package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Eminent extends ClaseBase {

    public Eminent(WebDriver driver) {super(driver);}

    By locatorBtnEspMasCercano = By.xpath("//a[@id='p-1']");
    By locatorPopUp = By.xpath("//h2[contains(text(),'Sucursales Exclusivas Éminent:')]");

    public void buscarEspacioCercano(){
        click(esperarPorElementoAClickear(locatorBtnEspMasCercano));
    }

    public String obtenerPoUp(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorPopUp));
    }
}
