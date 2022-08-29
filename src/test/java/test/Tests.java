package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pagesPromociones.Promociones;
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
    private BuscadorSucursales buscadorSucursales;
    private SucEmpresa sucEmpresa;
    private CajerosAutomaticos cajerosAutomaticos;
    private Promociones promociones;



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

        buscadorSucursales = new BuscadorSucursales(sucursalesyCajeros.getDriver());

        sucEmpresa = new SucEmpresa(sucursalesyCajeros.getDriver());

        cajerosAutomaticos = new CajerosAutomaticos(sucursalesyCajeros.getDriver());

        promociones = new Promociones(homePage.getDriver());
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
        homePage.cerrarBrowser();
    }


    @Test
    public void CP002_Busqueda() throws IOException {
        datos = data.obtenerDatosDePrueba("CP002_Busqueda");
        homePage.buscarError(datos.get(1));
        Assert.assertEquals(homePage.mensajeError(),datos.get(2));
        homePage.cerrarBrowser();

    }

    @Test
    public void CP003_EspaciEminent() throws Exception {
        datos = data.obtenerDatosDePrueba("CP003_Eminent");
        homePage.irASucursales();
        sucursalesyCajeros.buscarEspaciosEminent();
        eminent.buscarEspacioCercano();
        Assert.assertEquals(eminent.obtenerPoUp(),datos.get(1));
        homePage.cerrarTodo();

    }

    @Test
    public void CP004_SucursalesOk() throws Exception {
        datos = data.obtenerDatosDePrueba("CP004_Sucursal006");
        homePage.irASucursales();
        sucursalesyCajeros.buscarSucGalicia();
        buscadorSucursales.buscarSucursal(datos.get(1), datos.get(2), datos.get(3));
        Assert.assertEquals(buscadorSucursales.obtenerMensaje(),datos.get(4));
        homePage.cerrarTodo();
    }

    @Test
    public void CP005_CentrosBEmpresa() throws Exception {
        datos = data.obtenerDatosDePrueba("CP005_Empresa");
        homePage.irASucursales();
        sucursalesyCajeros.buscarSucEmpresa();
        Assert.assertEquals(sucEmpresa.obtenerMensaje(),datos.get(1));
        homePage.cerrarTodo();

    }

    @Test
    public void CP006_CajerosAutomaticos() throws Exception {
        datos = data.obtenerDatosDePrueba("CP006_Cajero");
        homePage.irASucursales();
        sucursalesyCajeros.buscarCajero();
        cajerosAutomaticos.buscarCajero(datos.get(1));
        Assert.assertEquals(cajerosAutomaticos.obtenerMensaje(),datos.get(2));
        homePage.cerrarTodo();

    }

    @Test
    public void CP007_Promociones() throws IOException {
        datos = data.obtenerDatosDePrueba("CP007_Promociones");
        homePage.irAPromociones();
        promociones.irAPromocion1();
        Assert.assertEquals(promociones.obtenerMensaje(),datos.get(1));
        homePage.cerrarBrowser();
    }

    @Test
    public void CP008_Promociones2() throws IOException {
        datos = data.obtenerDatosDePrueba("CP008_Promociones2");
        homePage.irAPromociones();
        promociones.irAPromocion2();
        Assert.assertEquals(promociones.obtenerMensaje2(),datos.get(1));
        homePage.cerrarBrowser();

    }


}
