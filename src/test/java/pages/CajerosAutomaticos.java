package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilidades.ClaseBase;

public class CajerosAutomaticos extends ClaseBase {

    public CajerosAutomaticos(WebDriver driver) {super(driver);}

    By locatorLocalidad = By.xpath("//tbody/tr[2]/td[2]/input[1]");

    By locatorBtnBuscar = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/img[1]");
    By locatorMensaje = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/form[1]/div[1]/table[2]/tbody[1]/tr[1]/td[6]/div[1]");

    public void buscarCajero(String localidad) {
        cambiarDePestaña();
        click(esperarPorElementoAClickear(locatorBtnBuscar));
        click(esperarPorElementoAClickear(locatorLocalidad));
        elegirCajero(localidad);
        click(esperarPorElementoAClickear(locatorBtnBuscar));
    }

    private void elegirCajero(String localidad){
        WebElement elemento = getDriver().findElement(By.id("slGba"));
        Select sel = new Select(elemento);
        sel.selectByVisibleText(localidad);
        sel.getFirstSelectedOption();

    }

    public String obtenerMensaje(){return obtenerTexto(locatorMensaje);}

}
