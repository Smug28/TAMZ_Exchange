package com.example.android.networkusage;

public class Entry {
    public final String kod;
    public final String stat;
    public final double cena;
    public final int mnozstvi;
 
    //TODO  rozsirit dalsi udaje, ktere se budou vest pro kazdou menu
    //TODO  upravit konstruktor
            
    Entry(String kod, String stat, double cena, int mnozstvi) {
        this.kod = kod;
        this.stat = stat;
        this.cena = cena;
        this.mnozstvi = mnozstvi;
    }
}
