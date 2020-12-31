package com.gussoft.shop.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
    public static Calendar calendar = Calendar.getInstance();
    private static String fecha;
    
    public Fecha(){
        
    }
    
    public static String Fecha(){
        SimpleDateFormat fec = new SimpleDateFormat("dd-MM-yy");
        fecha = fec.format(calendar.getTime());
        return fecha;
    }
    public static String FechaDB(){
        SimpleDateFormat fec = new SimpleDateFormat("yyyy-MM-dd");
        fecha = fec.format(calendar.getTime());
        return fecha;
    }
}
