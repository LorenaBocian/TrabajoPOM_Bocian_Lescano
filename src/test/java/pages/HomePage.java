package pages;

import utilidades.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends ClaseBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Identificador localizadores
    By locatorBtnOnlineBanking = By.partialLinkText("Online Banking");
    By locatorBuscador = By.xpath("//input[@id='buscadorHeader']");
    By locatorError = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]");
    By locatorSucursales = By.xpath("//a[@id='sucursales-y-cajeros']");
    By locatorPromociones = By.xpath("//body/main[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[3]/section[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/article[1]/a[1]/img[1]");

    //Acciones del page
    public void irAIniciarSesion(){
        click(esperarPorElementoAClickear(locatorBtnOnlineBanking));
    }

    public void buscarError(String busqueda){
        agregarTexto(esperarPorPresenciaElemento(locatorBuscador), busqueda);
        enter(locatorBuscador);
    }
    public String mensajeError(){return obtenerTexto(locatorError);}

    public void irASucursales(){
        click(esperarPorElementoAClickear(locatorSucursales));
    }

    public void irAPromociones(){
        click(esperarPorElementoAClickear(locatorPromociones));
    }

}
