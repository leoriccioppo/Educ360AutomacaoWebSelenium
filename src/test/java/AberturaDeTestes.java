import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import Pages.Client;
import Pages.Login;
//import Pages.User;



public class AberturaDeTestes {
	
	WebDriver driver;
	
	@Before
	public void abreBrowser() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonora\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testLogin() {
        Login login = new Login(driver);

        login.acessarPaginaDeLogin();
        login.preencherEmail();
        login.preencherSenha();
        login.clicarEntrar();

        // Verifica se o login foi bem-sucedido antes de prosseguir com a criação do cliente
        Assert.assertEquals("QA Test", driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/h1/small")).getText());
        
        // Criação cliente  
//        Client client = new Client(driver);
//        client.acessarPaginaDeCliente();
//        client.clicarNovo();
//        client.preencherNome("Leonora Riccioppo");
//        client.preencherDataNascimento("28/05/1994");
//        client.preencherEstado("RJ");
//        client.preencherCidade("Rio de Janeiro");
//        client.selecionarStatus("publicado");
//        client.inserir();
//        client.deletarClient(0);
        
        
        // Criação usuário
//        User user = new User(driver);
//        user.acessarPaginaDeUsuario();
//        user.clicarNovo();
//        user.preencherNome("Leonora Riccioppo");
//        user.preencherUsuario("leoriccioppo");
//        user.preencherSenha("senha123");
//        user.preencherNivel("Nível 1");
//        user.selecionarStatus("publicado");
//        user.inserir();
//        user.deletarUsuario(88);     
    }
	
	@After
	public void fechaBrowser() {
		driver.quit();
	}

}
