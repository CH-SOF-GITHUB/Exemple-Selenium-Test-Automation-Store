package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
    public static void main(String[] args) {
        // Déclaration WebDriver: ouvrir un navigateur google
        WebDriver driver = new ChromeDriver();

        // ouvrir le page se site web: "automation test store"
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        // Déclaration des web elements
        // déclaration de web element lien login or register
        WebElement Loginorregister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        Loginorregister.click();

        // Login Name
        WebElement LoginName = driver.findElement(By.xpath("//input[@id=\"loginFrm_loginname\"]"));
        LoginName.sendKeys("ChakerStore1");

        // Password
        WebElement Password = driver.findElement(By.xpath("//input[@id=\"loginFrm_password\"]"));
        Password.sendKeys("Azerty123");

        // Button Login
        WebElement Button = driver.findElement(By.xpath("//button[@title=\"Login\"]"));
        Button.click();

        // Button Logout
        WebElement Logout = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a"));
        Logout.click();

        // vérifier le message de logout
        String msgLogout = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/h1")).getText();
        //System.out.println(msgLogout);
        if(msgLogout.equals("ACCOUNT LOGOUT")){
            System.out.println("Logout avec succès");
        }else {
            System.out.println("Echec Logout");
        }
    }
}
