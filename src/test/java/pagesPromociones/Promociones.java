package pagesPromociones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class Promociones extends ClaseBase {

    public Promociones(WebDriver driver) {super(driver);}

    By locatorBusqueda = By.xpath("//input[@id='sb_e2a66250-8ba1-4604-b242-86a935f1e5e5searchInput']");
    By locatorMensaje = By.xpath("//strong[contains(text(),'No se han encontrado resultados para la búsqueda.')]");
    By locatorPromoDos = By.xpath("//body/main[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/section[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]/div[1]/div[2]/img[1]");
    By LocatorMensaje2 = By.xpath("//body/main[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/div[3]/div[1]/div[1]");
    public void irAPromocionBusqueda(String texto){
        agregarTexto(esperarPorPresenciaElemento(locatorBusqueda),texto);
        enter(locatorBusqueda);
    }
    public String obtenerMensaje(){return obtenerTexto(locatorMensaje);
    }

    public void irAPromocion2(){
        click(esperarPorElementoAClickear(locatorPromoDos));
    }
    public String obtenerMensaje2(){return obtenerTexto(LocatorMensaje2); }
}
