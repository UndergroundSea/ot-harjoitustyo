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

Varsinaisen sovelluslogiikan muodostavat sitten luokat MineField ja Pane, vaikka eivät nekään täysin eriytettyjä 
![Sovelluslogiikkakuvaus](https://github.com/UndergroundSea/ot-harjoitustyo/blob/master/dokumentaatio/Sovelluslogiikka.png)
