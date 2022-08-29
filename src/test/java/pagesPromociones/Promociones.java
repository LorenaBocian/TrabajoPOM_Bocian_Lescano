package pagesPromociones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Promociones extends ClaseBase {

    public Promociones(WebDriver driver) {super(driver);}

    By locatorPromoUno = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
    By locatorMensaje = By.xpath("//body/main[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/div[3]/div[1]/div[1]");
    By locatorPromoDos = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/a[1]");
    By LocatorMensaje2 = By.xpath("//body/main[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/div[3]/div[1]/div[1]");
    public void irAPromocion1(){
        click(esperarPorElementoAClickear(locatorPromoUno));
    }
    public String obtenerMensaje(){
        return obtenerTexto(locatorMensaje);
    }

    public void irAPromocion2(){
        click(esperarPorElementoAClickear(locatorPromoDos));
    }
    public String obtenerMensaje2(){return obtenerTexto(LocatorMensaje2); }
}
