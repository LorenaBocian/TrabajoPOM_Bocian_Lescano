package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Eminent;
import pages.HomePage;
import pages.LoginPage;
import pages.SucursalesyCajeros;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;

public class Tests {

    //Atributos
    private WebDriver driver;
    private DataDriven data;
    private List<String> datos;
    private PropertiesDriven properties;

    //Atributos (pages)
    private HomePage homePage;
    private LoginPage loginPage;
    private SucursalesyCajeros sucursalesyCajeros;
    private Eminent eminent;




    @BeforeSuite
    public void inicioSuitDePruebas(){
        properties = new PropertiesDriven();
        System.out.println("Inicio de Suit de pruebas automatizadas");
    }

    @BeforeClass
    public void preparacionClase(){

        data = new DataDriven();

        homePage = new HomePage(driver);

        homePage.conexionDriver(properties.obtenerProperty("rutaDriver"), properties.obtenerProperty("browserProperty"), properties.obtenerProperty("browser"));

        loginPage = new LoginPage(homePage.getDriver());

        sucursalesyCajeros = new SucursalesyCajeros(homePage.getDriver());

        eminent = new Eminent(sucursalesyCajeros.getDriver());

    }

    @BeforeMethod
    public void preparacionTest(){
        //Sin el file de properties
        homePage.cargarPagina(properties.obtenerProperty("url"));
        homePage.maximizarVentana();
    }

    @Test
    public void CP001_loginEmailFallido() throws IOException{
        datos = data.obtenerDatosDePrueba("CP001_loginFallido");
        homePage.irAIniciarSesion();
        loginPage.registrarse(datos.get(1), datos.get(2), datos.get(3));
        Assert.assertEquals(loginPage.obtenerMensajeError(),datos.get(4));
    }


    @Test
    public void CP002_Busqueda() throws IOException, InterruptedException {
        datos = data.obtenerDatosDePrueba("CP002_Busqueda");
        homePage.buscarError(datos.get(1));
        Assert.assertEquals(homePage.mensajeError(),datos.get(2));

    }

    @Test
    public void CP003_EspaciEminent() throws IOException {
        datos = data.obtenerDatosDePrueba("CP003_Eminent");
        homePage.irASucursales();
        sucursalesyCajeros.buscarEspaciosEminent();
        eminent.buscarEspacioCercano();
        Assert.assertEquals(eminent.obtenerPoUp(),datos.get(1));

    }

    @AfterMethod

    public void after(){
        homePage.cerrarBrowser();
    }
}
