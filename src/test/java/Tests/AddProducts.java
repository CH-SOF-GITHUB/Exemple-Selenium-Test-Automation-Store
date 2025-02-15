package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AddProducts {
    public static void main(String[] args) {
        // déclaration un selenium Web Driver: initialisation et ouverture un navigateur
        WebDriver driver = new ChromeDriver();
        // ouvrir la page web
        driver.navigate().to("https://automationteststore.com/");
        driver.manage().window().maximize();

        // déclaration des web elements et actions
        // type de produit "Apparel & accessories"
        WebElement typeProduct1 = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[2]/a"));
        typeProduct1.click();
        // affichage produits "T-shirts"
        WebElement view1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[2]/a"));
        view1.click();
        // clic button add product 1 "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
        WebElement buttonAdd1 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[3]/div[2]/div[3]/a"));
        buttonAdd1.click();
        // nom du produit 1
        String name1 = driver.findElement(By.className("bgnone")).getText();
        // clic button Add to Cart pour produit 1 "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie"
        WebElement AddToCart1 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[6]/ul/li/a"));
        AddToCart1.click();
        // interaction navigate back
        driver.navigate().back();
        driver.navigate().back();
        // clic button add product 2 "Casual 3/4 Sleeve Baseball T-Shirt"
        WebElement buttonAdd2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[4]/div[2]/div[3]/a"));
        buttonAdd2.click();
        // nom du produit 2
        String name2 = driver.findElement(By.className("bgnone")).getText();
        // clic button Add to Cart pour produit 2 "Casual 3/4 Sleeve Baseball T-Shirt"
        WebElement AddToCart2 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[6]/ul/li/a"));
        AddToCart2.click();
        // interaction navigate back
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        // type de produit "Makeup"
        WebElement typeProduct2 = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[3]/a"));
        typeProduct2.click();
        // affichage produits "Cheeks"
        WebElement view2 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[1]/a"));
        view2.click();
        // clic button add product 3 "Tropiques Minerale Loose Bronzer"
        WebElement buttonAdd3 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a"));
        buttonAdd3.click();
        String name3 = driver.findElement(By.className("bgnone")).getText();
        // clic button Add to Cart pour produit 3 "Tropiques Minerale Loose Bronzer"
        WebElement AddToCart3 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a"));
        AddToCart3.click();
        // interaction navigate back
        driver.navigate().back();
        driver.navigate().back();
        // clic button add produit 4 "Skinsheen Bronzer Stick"
        WebElement buttonAdd4 = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/a"));
        buttonAdd4.click();
        String name4 = driver.findElement(By.className("bgnone")).getText();
        // clic button Add to Cart pour produit 4 "Skinsheen Bronzer Stick"
        WebElement AddToCart4 = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
        AddToCart4.click();

        /* contains of table product-list */
        String table_product_list = driver.findElement(By.className("product-list")).getText();
        // liste des noms de 4 produits ajoutés
        List<String> names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        /* for(String pname : names) {
            System.out.println(pname);
        } */
        // resultat obtenu
        for (int i = 0; i < names.size(); i++) {
            if (table_product_list.contains(names.get(i))) {
                System.out.println("produit " + (i + 1) + " " + names.get(i) + " est ajouté avec succès");
            } else {
                System.out.println("échec d'ajouter un produit " + names.get(i));
            }
        }
    }
}