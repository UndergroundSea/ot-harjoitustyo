package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ebingerv
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void luoOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahaKasvaaEdullisenLounaanVerran() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahaKasvaaMaukkaanLounaanVerran() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void oikeaVaihtorahaKunEdullinen() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }
    
    @Test
    public void oikeaVaihtorahaKunMaukas() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void myydytEdullisetLounaatKasvaa() {
        kassa.syoEdullisesti(300);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaatLounaatKasvaa() {
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void rahaEiRiitaMikaanEiMuutu() {
        kassa.syoEdullisesti(3);
        kassa.syoMaukkaasti(5);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void JosRahaEiRiitaPalautetaanSe() {
        assertEquals(30, kassa.syoEdullisesti(30));
        assertEquals(50, kassa.syoMaukkaasti(50));
    }
    
    @Test
    public void rahaaKuluuEdullisenVerran() {
        kassa.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
    }
    
    @Test
    public void rahaaKuluuMaukkaanVerran() {
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    
    @Test
    public void palauttaaTrueEdullisella() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void palauttaaTrueMaukkaalla() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void josRahaRiittaaMyydytEdullisetLounaatKasvaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josRahaRiittaaMyydytMaukkaatLounaatKasvaa() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaLiianVahanRahaa() {
        kortti.otaRahaa(800);
        assertEquals("saldo: 2.0", kortti.toString());
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 2.0", kortti.toString());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void falseJosRahaEiRiita() {
        kortti.otaRahaa(800);
        assertEquals("saldo: 2.0", kortti.toString());
        assertEquals(false, kassa.syoEdullisesti(kortti));
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiEiMuutaKassaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLataus() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 11.0", kortti.toString());
    }
    
    @Test
    public void kassastaLataus() {
        kassa.lataaRahaaKortille(kortti, 100);
        assertEquals("saldo: 11.0", kortti.toString());
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
}
