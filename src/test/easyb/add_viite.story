import wad.spring.config.*
import wad.spring.controller.*
import wad.spring.domain.*
import wad.spring.repository.*
import wad.spring.service.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can add references to site'

scenario "user can add reference to site", {
    given 'user is on front page', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080");
        System.out.println( driver.getPageSource() );

    }   
    when 'when all fields are submitted', {
        driver.getPageSource();
        element = driver.findElement(By.name("referenceId"));
        element.sendkeys("123456");
        element = driver.findElement(By.name("author"));
        element.sendkeys("A. Ankka");
        element = driver.findElement(By.name("title"));
        element.sendkeys("A. Ankan tarinat");
        element = driver.findElement(By.name("bookTitle"));
        element.sendkeys("Elämäni seikkailut");
        element = driver.findElement(By.name("itemYear"));
        element.sendkeys("1989");
        element.submit();
    }
    then 'a reference appears on page', {
         driver.getPageSource().contains("[1234567] A. Ankka A. Ankan tarinat Elämäni seikkailut 1989").shouldBe true
    } 
}

