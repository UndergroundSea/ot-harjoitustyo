**Ohjelmistotekniikka, harjoitustyö**

**Miinaharava-peli**

---------------------------------

[Työaikakirjanpito](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[GitHub-release](https://github.com/UndergroundSea/ot-harjoitustyo/releases/tag/viikko6)

[Käyttöohje](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/kaytto-ohje.md)

[Arkkitehtuurikuvaus](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuvaus.md)

------------------------------------------

Testien ajaminen: mvn test

Testikattavuusraportti (target/site/jacoco/index.html): mvn jacoco:report

Checkstyle (target/site/checkstyle.html): mvn jxr:jxr checkstyle:checkstyle

.jar-tiedoston muodostaminen (/target): mvn package

JavaDocin generoiminen (/target/site/apidocs/): mvn javadoc:javadoc
