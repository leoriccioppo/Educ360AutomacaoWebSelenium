package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class User extends BasePage{
	
	public User(WebDriver driver) {
        super(driver);
    }
	
	public void acessarPaginaDeUsuario() {
		driver.get("https://educ360dev.com.br/qa-test/admin/adm_usuarios");
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
	
	public void preencherUsuario(String usuario) {
		driver.findElement(By.name("usuario")).sendKeys(usuario);
	}
	
	public void preencherSenha(String senha) {
		driver.findElement(By.name("senha")).sendKeys(senha);
	}
	
	public void preencherGrupoUsuarios(String grupo) {
		driver.findElement(By.name("id_grupo_usuarios")).sendKeys(grupo);
	}
	
	public void preencherNivel(String nivel) {
		driver.findElement(By.name("nivel")).sendKeys(nivel);
	}
	
	public void selecionarStatus(String status) {
		if (status.equalsIgnoreCase("publicado")) {
			driver.findElement(By.id("status_publicado")).findElement(By.xpath("/html/body/div/div/div[2]/form/div/div[2]/div[7]/div[1]/div/label")).click();
	    } else if (status.equalsIgnoreCase("inativo")) {
	        driver.findElement(By.id("status_inativo")).click();
	    }
	}
	
	public void inserir() {
		driver.findElement(By.name("inserir")).click();
	}
	
	public void deletarUsuario(int idUsuario) {
	    // Localizar o elemento na tabela com base no ID do usuário
	    driver.findElement(By.xpath("//td[contains(.,'" + idUsuario + "')]")).click();
	    
	    // Localizar o link "Deletar" e clicar nele
	    driver.findElement(By.linkText("Deletar")).click();
	    
	    // Aceitar o pop-up de confirmação
	    driver.switchTo().alert().accept();
	}
	
	public void inativarUsuario(int idUsuario) {	
		driver.findElement(By.xpath("//td[contains(.,'" + idUsuario + "')]")).click();
		driver.findElement(By.linkText("Inativar")).click();
		driver.switchTo().alert().accept();	
	}
	
	public void criarUsuario(String nome, String usuario, String senha, String nivel, String status, String caminhoImagem) {
		acessarPaginaDeUsuario();
		clicarNovo();
		preencherNome(nome);
		
		if (!caminhoImagem.isEmpty()) {
	        preencherImagem(caminhoImagem);
	    }	
		preencherUsuario(usuario);
		preencherSenha(senha);
		preencherNivel(nivel);
		selecionarStatus(status);
		inserir();
		
	}

 }