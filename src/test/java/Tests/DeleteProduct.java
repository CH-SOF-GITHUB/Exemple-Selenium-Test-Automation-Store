package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class DeleteProduct {
    public static void main(String[] args) throws InterruptedException {
        // Déclaration WebDriver: ouvrir un navigateur google
        WebDriver driver = new ChromeDriver();

        // ouvrir le page se site web: "automation test store"
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        /* Tester la fonctionnalité Ajouter un produit
        et déclaration des web elements */

        // + tester la suppression d'un produit

        // choisir un type de produit "Books"
        WebElement TypeProduct = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[8]/a"));
        TypeProduct.click();

        // afficher le type de produit "Paperback"
        WebElement viewTypeProduct = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[2]/a"));
        viewTypeProduct.click();

        // cliquer sur l'icone "add to panier"
        WebElement AddProduct1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[3]/div[2]/div[3]/a"));
        AddProduct1.click();

        // cliquer sur l'icone "panier"
        WebElement Panier1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[3]/div[2]/div[3]/div[1]/a"));
        Panier1.click();

        driver.navigate().back();

        WebElement AddProduct2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a"));
        AddProduct2.click();

        WebElement Panier2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/a"));
        Panier2.click();

        //String Product2Name = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[3]/td[2]/a")).getText();

        String Product1Name = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[2]/a")).getText();

        WebElement DeleteProduct1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[7]/a"));
        DeleteProduct1.click();

        List<String> productnames = new ArrayList<>();
        productnames.add(Product1Name);
        System.out.println(Product1Name);

        //System.out.println(Product2Name);
        String tableproduct = driver.findElement(By.className("product-list")).getText();

        Thread.sleep(2000);

        for(int i = 0; i <productnames.size(); i++) {
            if (!tableproduct.contains(productnames.get(i))) {
                System.out.println("Produit " + productnames.get(i) + " est supprimé avec succès");
            } else {
                System.out.println("échec de suppression de produit " + productnames.get(i));
            }
        }

        // + tester la suppression plusieurs produits
    }
}