package com.example.android.networkusage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by smuggler on 06.10.15.
 */
public enum Flags {
    AUD(R.drawable.au),
    BRL(R.drawable.br),
    BGN(R.drawable.bg),
    CNY(R.drawable.cn),
    DKK(R.drawable.dk),
    HRK(R.drawable.hr),
    INR(R.drawable.in),
    ILS(R.drawable.il),
    JPY(R.drawable.jp),
    ZAR(R.drawable.za),
    CAD(R.drawable.ca),
    HUF(R.drawable.hu),
    MYR(R.drawable.my),
    MXN(R.drawable.mx),
    NOR(R.drawable.no),
    NZD(R.drawable.nz),
    PLN(R.drawable.pl),
    RON(R.drawable.ro),
    RUB(R.drawable.ru),
    SEK(R.drawable.se),
    THB(R.drawable.th),
    TRY(R.drawable.tr),
    USD(R.drawable.us),
    GBP(R.drawable.gb),
    EUR(R.drawable.eu),
    CZK(R.drawable.cz);

    private int resId;

    private Flags(int res){
        resId = res;
    }

    public static int get(String s){
        for (Flags f : Flags.values())
            if (f.name().equals(s))
                return f.resId;
        return 0;
    }
}
