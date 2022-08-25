package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

import static java.lang.Thread.sleep;

public class LoginPage extends ClaseBase {

    public LoginPage(WebDriver driver) {super(driver);}

    //Identificar localizadores
    By locatorNroDni = By.name("DocumentNumber");
    By locatorUsuario = By.id("UserName");
    By locatorPass = By.name("Password");
    By locatorBtnIniciar = By.xpath("//button[@id='submitButton']");

    //Locator mensajeError
     By locatorLblError = By.xpath("//h5[contains(text(),'No es posible ingresar')]");



    //Acciones del page
    public void registrarse(String dni, String user, String pass){

        agregarTexto(esperarPorPresenciaElemento(locatorNroDni), dni);
        agregarTexto(esperarPorPresenciaElemento(locatorUsuario), user);
        agregarTexto(esperarPorPresenciaElemento(locatorPass), pass);
        click(esperarPorElementoAClickear(locatorBtnIniciar));
    }

    public String obtenerMensajeError(){
        return obtenerTexto(esperarPorPresenciaElemento(locatorLblError));
    }


}
