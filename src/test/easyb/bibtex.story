import wad.spring.config.*
import wad.spring.controller.*
import wad.spring.domain.*
import wad.spring.repository.*
import wad.spring.service.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can list references to a BibTex-file'

scenario "user can type a name for the Bibtex-file", {
    given 'field for the name is given'
    when 'a valid name is given'
    then 'a valid file is saved' 
}

scenario "user can't save the BibTex-file without a name for it", {
    given 'field for the name is given'
    when 'no name is given'
    then 'file is not saved' 
}
