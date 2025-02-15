package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckOut {

    public static void main(String[] args) throws InterruptedException {
        // Déclaration WebDriver: ouvrir un navigateur google
        WebDriver driver = new ChromeDriver();

        // ouvrir le page se site web: "automation test store"
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        /* Tester la fonctionnalité Checkout: vérifier l'ajout d'un produit
        et déclaration des web elements */

        // choisir un type de produit "Books"
        WebElement TypeProduct = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[8]/a"));
        TypeProduct.click();

        // afficher la liste des produits "Paperback"
        WebElement viewTypeProduct = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[2]/a"));
        viewTypeProduct.click();

        // cliquer sur l'icone "ajouter en panier"
        WebElement AddBtn = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a"));
        AddBtn.click();

        // ajouter en temps entre les 2 actions (ajouter le produit et vérifier le panier)
        Thread.sleep(2000);

        // cliquer sur le l'icone "panier"
        WebElement panier = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/a"));
        panier.click();

        // cliquer sur le bouton Checkout
        WebElement CheckOut = driver.findElement(By.xpath("//*[@id=\"cart_checkout1\"]"));
        CheckOut.click();

        // Connexion pour continuer Checkout
        // Login Name
        WebElement LoginName = driver.findElement(By.xpath("//input[@id=\"loginFrm_loginname\"]"));
        LoginName.sendKeys("ChakerStore1");

        // Password
        WebElement Password = driver.findElement(By.xpath("//input[@id=\"loginFrm_password\"]"));
        Password.sendKeys("Azerty123");

        // Button Login
        WebElement Button = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        Button.click();

        // cliquer sur le boutton "Confirmer Order"
        WebElement ConfirmOrder = driver.findElement(By.xpath("//button[@title=\"Confirm Order\"]"));
        ConfirmOrder.click();

        // message de confirmation checkout
        Thread.sleep(3000);

        String msgCheckout = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/h1")).getText();
        System.out.println(msgCheckout);
        if(msgCheckout.equals("YOUR ORDER HAS BEEN PROCESSED!")){
            System.out.println("Checkout produits avec succès");
        }else {
            System.out.println("Echec Checkout produits");
        }
    }
}