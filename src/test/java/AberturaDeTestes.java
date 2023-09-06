import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Pages.Login;




public class AberturaDeTestes {
	
	WebDriver driver;
	
	@Before
	public void abreBrowser() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonora\\Desktop\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	//Verifica se o login é bem-sucedido com credenciais válidas
	public void testLogin() {
        Login login = new Login(driver);

        login.acessarPaginaDeLogin();
        login.preencherEmail();
        login.preencherSenha();
        login.clicarEntrar();

        Assert.assertEquals("QA Test", driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/h1/small")).getText());       
    }
	
	@Test 
	// Verifica se o login falha com credenciais inválidas e exibe a mensagem de erro esperada
	public void testLoginErro() {
	    Login login = new Login(driver);

	    login.acessarPaginaDeLogin();
	    login.preencherEmail();
	    login.preencherSenhaIncorreta();	    
	    login.clicarEntrar();

	    String mensagemDeErro = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div")).getText();
	    Assert.assertTrue(mensagemDeErro.contains("Usuário ou senha inválidos"));
	    Assert.assertTrue(mensagemDeErro.contains("×"));
	}
	
	@Test
	//
	public void testSearchUser() {	
		User user = new User();
		testLogin();
	    String termoBusca = "Nome do Usuário"; // Substitua pelo nome do usuário que deseja buscar

	    user.acessarPaginaUsuario();
	    user.realizarBuscaUsuario(termoBusca);

	    // Adicione asserções para verificar se os resultados da busca são os esperados
	}
	
	
	
	@After
	public void fechaBrowser() {
		driver.quit();
	}

}
