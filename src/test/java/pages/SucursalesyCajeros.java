package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class SucursalesyCajeros extends ClaseBase {

    public SucursalesyCajeros(WebDriver driver) {super(driver);}

    By locatorEminent = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[2]/a[1]");
    By locatorSucursales = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]");
    By locatorSucEmpresas = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/a[1]");
    By locatorCajero = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[4]/map[1]/area[2]");

    public void buscarEspaciosEminent(){
        click(esperarPorElementoAClickear(locatorEminent));
    }
    public void buscarSucGalicia(){click(esperarPorElementoAClickear(locatorSucursales));}
    public void buscarSucEmpresa(){click(esperarPorElementoAClickear(locatorSucEmpresas));}
    public void buscarCajero(){click(esperarPorElementoAClickear(locatorCajero));}

}
