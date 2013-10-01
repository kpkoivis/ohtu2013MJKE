import wad.spring.config.*
import wad.spring.controller.*
import wad.spring.domain.*
import wad.spring.repository.*
import wad.spring.service.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can choose a valid id for a new reference'

scenario "user can type a valid id", {
    given 'field for the id is given'
    when 'a valid id is given'
    then 'a valid id is saved' 
}


