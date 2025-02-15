package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    public static void main(String[] args) throws InterruptedException {
        // déclaration WebDriver pour ouvrir un navigateur google
        WebDriver driver = new ChromeDriver();
        // ouvrir le page se site web: "automation test store"
        driver.get("https://automationteststore.com/");
        driver.manage().window().maximize();

        // tester la fonctionnalité register
        // déclaration de web element lien login or register
        WebElement Loginorregister = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        Loginorregister.click();

        // déclaration de web element bouton Continue
        WebElement Continue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        Continue.click();

        // déclaration dew web elements de la formulaire register
        // First Name
        WebElement FirstName = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        FirstName.sendKeys("John");
        // Last Name
        WebElement LastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        LastName.sendKeys("Doe");
        // Email
        WebElement Email = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        Email.sendKeys("store@gmail.com");
        // Telephone
        WebElement Telephone = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        Telephone.sendKeys("+21622000897");
        // Fax
        WebElement Fax = driver.findElement(By.xpath("//input[@name=\"fax\"]"));
        Fax.sendKeys("+21697005897");
        // Company
        WebElement Company = driver.findElement(By.xpath("//input[@name=\"company\"]"));
        Company.sendKeys("Entreprise IT");
        // Address 1
        WebElement Address1 = driver.findElement(By.xpath("//input[@name=\"address_1\"]"));
        Address1.sendKeys("Rue de la Ville de Sfax, Tunisie");
        // Address 2
        WebElement Address2 = driver.findElement(By.xpath("//input[@name=\"address_2\"]"));
        Address2.sendKeys("Rue de Tunis, Tunisie");
        // City
        WebElement City = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        City.sendKeys("Sfax");
        // Country
        WebElement Country = driver.findElement(By.xpath("//select[@name=\"country_id\"]"));
        Select country = new Select(Country);
        country.selectByValue("214");

        // ajouter un temps entre les 2 actions: section Country et Region, si non region ne pas sélectionné
        Thread.sleep(2000);

        // Region / State
        WebElement state = driver.findElement(By.xpath("//select[@id=\"AccountFrm_zone_id\"]"));
        Select region = new Select(state);
        region.selectByVisibleText("Sfax");
        // ZIP Code
        WebElement ZipCode = driver.findElement(By.xpath("//input[@name=\"postcode\"]"));
        ZipCode.sendKeys("20000");
        // Login name
        WebElement loginName = driver.findElement(By.xpath("//input[@name=\"loginname\"]"));
        loginName.sendKeys("JohnStore2");
        // Password
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        password.sendKeys("Azerty123");
        // Password Confirm
        WebElement password_confirm = driver.findElement(By.xpath("//input[@name=\"confirm\"]"));
        password_confirm.sendKeys("Azerty123");
        // Subscribe Yes/No
        WebElement subscribe = driver.findElement(By.xpath("//input[@id=\"AccountFrm_newsletter1\"]"));
        subscribe.click();
        // Privacy
        WebElement privacy = driver.findElement(By.xpath("//input[@id=\"AccountFrm_agree\"]"));
        privacy.click();
        // Button Continue
        WebElement BtnContinue = driver.findElement(By.xpath("//button[@title=\"Continue\"]"));
        BtnContinue.click();

        // vérification register
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://automationteststore.com/index.php?rt=account/success")){
            System.out.println("compte crée avec succéss et affichage d'un message de confirmation");
        }else {
            System.out.println("échec de création d'un comte Store");
        }
    }
}