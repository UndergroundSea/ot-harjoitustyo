**Arkkitehtuurikuvaus**

-------------------------------------------

**Rakenne**

Ohjelma sisältää kolme pakkausta. Pakkaus userinterface sisältää pelkän graafisen käyttöliittymän sisältävän luokan nimeltä UserInterface. Pakkaus gamesetting sisältää pelin asetteluun liittyvät luokat eli luokat joilla saadaan aikaiseksi aloitusnäkymän sisältö (StartingInterface) ja siitä vaikeusaste valittua (GameMode). Pakkaus minefield sisältää luokat joita tarvitaan itse pelin rakentamiseen (MineField) ja sen pelaamiseen (Pane ja MineField).


-------------------------------------------

**Käyttöliittymä**

Pakkauksen userinterface luokka UserInterface luo aloitusnäkymä-olion ja sille scenen, johon sitten tämä aloitusnäkymä luodaan.
Luokka UserInterface luo tämän aloitusnäkymän luokan StartingInterface kautta. Kun aloitusnäkymästä vaihdetaan pelinäkymään, pelinäkymä luodaan luokan gameMode kautta.

![Käyttöliittymäkuvaus](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/UserInterface.png)

-----------------------------------------------

**Sovelluslogiikka**

Varsinaisen sovelluslogiikan muodostavat sitten luokat MineField ja Pane, vaikka eivät nekään täysin eriytettyjä graafisesta käyttöliittymästä ole. Luokka Pane hoitaa kaiken ruutuihin liittyvän, eli suurimman osan pelin aikana tapahtuvista tapahtumista. Luokan Pane metodien avulla ruudut käännetään ja samassa tutkitaan hävitäänkö tai voitetaanko peli. Luokka Minefield laskee pelin aikana ruudun ympärillä olevien miinojen määrän ja ilmoittaa sen kyseiselle ruudulle.

![Sovelluslogiikkakuvaus](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/Sovelluslogiikka.png)

-------------------------------------------

**Tietojen tallennus**

Sovellus tallentaa voitettujen pelien määrän tiedostoon nimeltä save.txt . Sellaisen tiedoston on pakko olla olemassa ohjelman pyörimisen mahdollistamiseksi, aina kun voitetaan peli, se tiedosto korvataan uudella samannimisellä tiedostolla, joka sisältää uuden voitettujen pellien määrän.

--------------------------------

**Päätoiminnallisuudet**

*public void start*

Metodi luo pääluokassa sovelluksen aloitusnäkymän, josta voi valita pelin vaikeustason.

![publicVoidStart](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/publicVoidStart.PNG)

*public void create game*

Metodi luo GameMode luokassa uuden pelin aloitusnäkymän valitun vaikeustason mukaisesti. Peli on sitten valmis pelattavaksi.

![publicVoidCreateGame](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/publicVoidCreateGame.PNG)

*public void turn pane*

Metodi toimii Pane luokassa ja kääntää ruudun. Tämä sekvenssikaavion esimerkissä käännetty ruutu ei sisällä miinnaa, on ensimmäinen joka käännetään ja sen ympärillä on kolme miinaa.

![publicVoidTurnPane](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/publicVoidTurnPane().PNG)
