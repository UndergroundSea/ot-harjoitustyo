package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void latausToimiiOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeJosRiittaa() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneJosEiRiita() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test 
    public void palauttaaTrue() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalse() {
        assertEquals(false, kortti.otaRahaa(15));
    }
    
}
