
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Eliel Ingervo
 */
public class MaksukorttiTest {

    public MaksukorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

//    @Before
//    public void setUp() {
//    }

    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {

//        Maksukortti kortti = new Maksukortti(10);

        String vastaus = kortti.toString();

        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);

    }

    @Test
    public void syoEdullisestiVahentaaOikein() {

//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());

    }

    @Test
    public void syoMaukkaastiVahentaaOikein() {

//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());

    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {

//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());

    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }
    
    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {

//        Maksukortti kortti = new Maksukortti(10);

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());

    }
    
    @Test
    public void negatiivisenSummanLataaminenEiMuutaKortinSaldoa() {
        
        kortti.lataaRahaa(-20);
        
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
        
    }
    
    @Test
    public void kortillaPystyyOstamaanEdullisenKunOnSenVerranRahaa () {
        
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.lataaRahaa(0.5);
        assertEquals("Kortilla on rahaa 2.5 euroa", kortti.toString());
        kortti.syoEdullisesti();
        
    }
    
    @Test
    public void kortillaPystyyOstamaanMaukkaanKunOnSenVerranRahaa () {
        
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.lataaRahaa(2);
        assertEquals("Kortilla on rahaa 4.0 euroa", kortti.toString());
        kortti.syoMaukkaasti();
        
    }
    
}