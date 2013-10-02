import wad.spring.config.*
import wad.spring.controller.*
import wad.spring.domain.*
import wad.spring.repository.*
import wad.spring.service.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can use nordic characters in references'

scenario "user can type references using nordic characters", {
    given 'typing with nordic characters is possible'
    when 'nordic characters are used in references'
    then 'a saved BibTex file includes nordic characters in LateX' 
}


