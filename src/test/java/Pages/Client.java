package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Client extends BasePage {

	public Client(WebDriver driver) {
        super(driver);
    }
	
	public void acessarPaginaDeCliente() {
		driver.get("https://educ360dev.com.br/qa-test/admin/clientes");
	}
	
	public void clicarNovo() {
		 driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div/div[2]/div[1]/a[1]")).click();
	}
	
	public void preencherNome(String nome) {
		driver.findElement(By.name("nome")).sendKeys(nome);
	}

	
	public void preencherImagem(String caminhoImagem) {
		driver.findElement(By.name("imagem")).sendKeys(caminhoImagem);
	}
	
	public void preencherDataNascimento(String dataNascimento) {
		driver.findElement(By.name("data_nascimento")).sendKeys(dataNascimento);
	}
	
	public void preencherEstado(String estado) {
		driver.findElement(By.name("estado")).sendKeys(estado);
	}
	
	public void preencherCidade(String cidade) {
		driver.findElement(By.name("cidade")).sendKeys(cidade);
	}
	
	public void selecionarStatus(String status) {
		if (status.equalsIgnoreCase("publicado")) {
			driver.findElement(By.xpath("//*[@id=\"page-inner\"]/form/div/div[2]/div[7]/div[1]/div/label")).click();
	    } else if (status.equalsIgnoreCase("inativo")) {
	        driver.findElement(By.xpath("//*[@id=\"page-inner\"]/form/div/div[2]/div[7]/div[2]/div/label")).click();
	    }
	}
	
	public void inserir() {
		driver.findElement(By.name("inserir")).click();
	}
	
	public void deletarClient(int idClient) {
		driver.findElement(By.xpath("//td[contains(.,'" + idClient + "')]")).click();
		driver.findElement(By.linkText("Deletar")).click();
		driver.switchTo().alert().accept();		
	}
	
	public void inativarClient(int idClient) {
		driver.findElement(By.xpath("//td[contains(.,'" + idClient + "')]")).click();
		driver.findElement(By.linkText("Inativar")).click();
		driver.switchTo().alert().accept();	
	}
	
	public void criarCliente(String nome, String dataNascimento, String estado, String cidade, String status, String caminhoImagem) {
	    acessarPaginaDeCliente();
	    clicarNovo();
	    preencherNome(nome);

	    if (!caminhoImagem.isEmpty()) {
	        preencherImagem(caminhoImagem);
	    }

	    preencherDataNascimento(dataNascimento);
	    preencherEstado(estado);
	    preencherCidade(cidade);
	    selecionarStatus(status);
	    inserir();
	}
	
}
