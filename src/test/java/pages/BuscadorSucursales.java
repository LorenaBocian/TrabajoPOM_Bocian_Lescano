package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilidades.ClaseBase;

public class BuscadorSucursales extends ClaseBase {

    public BuscadorSucursales(WebDriver driver) {super(driver);}
    By locatorNroSuc = By.name("codSucursal");
    By locatorCalle = By.name("calle");
    By locatorBtnBuscar = By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/section[1]/div[2]/div[2]/form[1]/div[1]/div[4]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]/img[1]");
    By locatorLocalidadCorrecta = By.xpath("//div[contains(text(),'FLORES')]");
    public void buscarSucursal(String barrio, String cod, String calle){
        cambiarDePestaña();
        elegirBarrio(barrio);
        agregarTexto(esperarPorPresenciaElemento(locatorNroSuc), cod);
        agregarTexto(esperarPorPresenciaElemento(locatorCalle), calle);
        click(esperarPorElementoAClickear(locatorBtnBuscar));
    }

    public String obtenerMensaje(){
        return obtenerTexto(locatorLocalidadCorrecta);
    }

    public void elegirBarrio(String barrio){
        WebElement elemento = getDriver().findElement(By.id("slCapFed"));
        Select sel = new Select(elemento);
        sel.selectByVisibleText(barrio);
        sel.getFirstSelectedOption();

    }
}
