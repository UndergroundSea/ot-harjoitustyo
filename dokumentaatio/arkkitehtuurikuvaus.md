**Arkkitehtuurikuvaus**

-------------------------------------------

**Rakenne**

Ohjelma sisältää kolme pakkausta. Pakkaus userinterface sisältää pelkän graafisen käyttöliittymän sisältävän luokan nimeltä UserInterface. Pakkaus gamesetting sisältää pelin asetteluun liittyvät luokat eli luokat joilla saadaan aikaiseksi aloitusnäkymän sisältö (StartingInterface) ja siitä vaikeusaste valittua (GameMode). Pakkaus minefield sisältää luokat joita tarvitaan itse pelin rakentamiseen (MineField) ja sen pelaamiseen (Pane ja MineField).


-------------------------------------------

**Käyttöliittymä**

Pakkauksen userinterface luokka UserInterface luo aloitusnäkymä-olion ja sille scenen, johon sitten tämä aloitusnäkymä luodaan.


//gamesettings-pakkauksen luokat StartingInterface ja GameMode tukevat luokkaa UserInterface käyttöliittymätoiminnassa. Luokka StartingInterface auttaa luomaan aloitusnäkymää ja asettaa toiminnallisuudet napeille, joista voi päättää pelin vaikeusasteen.Luokka
//Ehkä tulee erikseen, koska eri pakkaus
