package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AddProduct {
    public static void main(String[] args) {
        // controle et ouverture d'un navigateur google
        WebDriver driver = new ChromeDriver();

        // ouvrir la page de site web automation test store
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        /* Tester la fonctionnalité Ajouter un produit
        et déclaration des web elements */

        // choisir un type de produit "Fragrance"
        WebElement TypeProduct = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[5]/a"));
        TypeProduct.click();

        // choisir et cliquer sur le lien "Men"
        WebElement Men = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[1]/div/a"));
        Men.click();

        // afficher le produit (ck one shock for him Deodorant)
        WebElement Product1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/a"));
        Product1.click();

        WebElement NameProduct1 = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span"));
        String productname1 = NameProduct1.getText();

        // cliquer sur le bouton "Add to Cart"
        WebElement AddToCart1 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
        AddToCart1.click();

        driver.navigate().back();
        driver.navigate().back();

        WebElement Product2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[2]/div[2]/a"));
        Product2.click();

        WebElement NameProduct2 = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div[2]/div/div/h1/span"));
        String productname2 = NameProduct2.getText();

        WebElement AddCart2 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a"));
        AddCart2.click();

        // déclaration d'une liste
        List<String> productnames = new ArrayList<>();
        productnames.add(productname1);
        productnames.add(productname2);

        // Texte contenu de tableau product list
        String tableproduct = driver.findElement(By.className("product-list")).getText();

        for(int i = 0; i < productnames.size(); i++){
            if(tableproduct.contains(productnames.get(i))){
                System.out.println("Le produit " + productnames.get(i) + " existe");
            } else {
                System.out.println("Le produit " + productnames.get(i) + " n'existe pas");
            }
        }
    }
}