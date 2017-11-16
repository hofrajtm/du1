/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author jethro
 */
public class Du1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Vypíše funkci programu a písmena pro výběr zobrazení.
        System.out.println("Program pro výpočet souřadnic rovnoběžek a poledníků válcových tečných zobrazení:");
        System.out.println("A - Marinovo");
        System.out.println("L - Lambertovo");
        System.out.println("B - Braunovo");
        System.out.println("M - Mercatorovo");
        System.out.println("W - Wetchovo");
        
        /* Podle zadaného písmene určí parametr 'z' (zobrazení). Uzná pouze
        písmena z nabídky na začátku, v jiném případě je program ukončen.*/
        System.out.print("Zadejte zobrazení:");
        char z = readChar();
        if (z == 'A' || z == 'L' || z == 'B' || z == 'M' || z == 'W') {
        } else {
            System.out.println("Zobrazení bylo zadáno špatně.");
            System.exit(0);
        }

        /* Podle zadaného čísla určí parametr 'm' (měřítko). Uzná pouze kladné
        hodnoty, v případě záporné hodnoty je program ukončen.*/
        System.out.print("Zadejte měřítko:");
        int m = readInt();
        if (m > 0) {
        } else {
            System.out.println("Měřítko bylo zadáno špatně.");
            System.exit(0);
        }

        /* Podle zadaného čísla určí parametr 'r' (poloměr Země). Uzná pouze
        kladné hodnoty. Při zadání '0' je poloměr roven 6371.11 km. V případě
        záporné hodnoty je program ukončen.*/
        System.out.print("Zadejte poloměr Země (v km):");
        double r = readDouble();
        if (r > 0) {
            r = r * 100000;
        } else if (r == 0) {
            r = 6371.11 * 100000;
        } else {
            System.out.println("Poloměr Země byl zadán špatně.");
            System.exit(0);
        }
        
        /* Na základě zadaných parametrů jsou spočítány a vypsány nejprve
        rovnoběžky (po 10° od -90° do 90°) a následně poledníky (po 10°
        od -180° DO 180°).*/
        if (z == 'A') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(zobrazeniARovnobezky(r, u, m), 10));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(zobrazeniAPoledniky(r, v, m), 10));
            }
        } else if (z == 'L') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(zobrazeniLRovnobezky(r, u, m), 10));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(zobrazeniLPoledniky(r, v, m), 10));
            }
        } else if (z == 'B') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(zobrazeniBRovnobezky(r, u, m), 10));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(zobrazeniBPoledniky(r, v, m), 10));
            }   
        } else if (z == 'M') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(zobrazeniMRovnobezky(r, u, m), 10));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(zobrazeniMPoledniky(r, v, m), 10));
            }  
        } else if (z == 'W') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(zobrazeniWRovnobezky(r, u, m), 10));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(zobrazeniWPoledniky(r, v, m), 10));
            }
        }
        
        System.out.println();
        
        /* Je v činnost uveden cyklus do while pro výpočet souřadnic bodu.
        Nejprve je uživatel dotázán na parametr 'u' (zeměpisnou šířku) a
        následně na parametr 'v' (zeměpisnou délku). Na základě parametrů
        zadaných zde i parametrů zadaných na záčátku programu jsou vypočteny
        souřadnice bodu na papíře. Cyklus je ukončen v případě rovnosti obou
        parametrů 'u' a 'v' nule.*/
        int u,v;
        do {
            System.out.print("Zadejte zeměpisnou šírku: ");
            u = readInt();
            if (u <= 90 && u>= -90) {
                u = u;
            } else {
                System.out.println("Zeměpisná šířka byla zadána špatně.");
                System.exit(0);
            }
            
            System.out.print("Zadejte zeměpisnou délku: ");
            v = readInt();
            if (v <= 180 && v>= -180) {
                v = v;
            } else {
                System.out.println("Zeměpisná délka byla zadána špatně.");
                System.exit(0);
            }
            
            if (z == 'A') {
                System.out.print("Rovnoběžka: ");
                vypis(zaokrouhli(zobrazeniARovnobezky(r, u, m), 10));
                System.out.println();
                System.out.print("Poledník: ");
                vypis(zaokrouhli(zobrazeniAPoledniky(r, v, m), 10));
            } else if (z == 'L') {
                System.out.print("Rovnoběžka: ");
                vypis(zaokrouhli(zobrazeniLRovnobezky(r, u, m), 10));
                System.out.println();
                System.out.print("Poledník: ");
                vypis(zaokrouhli(zobrazeniLPoledniky(r, v, m), 10));
            } else if (z == 'B') {
                System.out.print("Rovnoběžka: ");
                vypis(zaokrouhli(zobrazeniBRovnobezky(r, u, m), 10));
                System.out.println();
                System.out.print("Poledník: ");
                vypis(zaokrouhli(zobrazeniBPoledniky(r, v, m), 10));
            } else if (z == 'M') {
                System.out.print("Rovnoběžka: ");
                vypis(zaokrouhli(zobrazeniMRovnobezky(r, u, m), 10));
                System.out.println();
                System.out.print("Poledník: ");
                vypis(zaokrouhli(zobrazeniMPoledniky(r, v, m), 10));
            } else if (z == 'W') {
                System.out.print("Rovnoběžka: ");
                vypis(zaokrouhli(zobrazeniWRovnobezky(r, u, m), 10));
                System.out.println();
                System.out.print("Poledník: ");
                vypis(zaokrouhli(zobrazeniWPoledniky(r, v, m), 10));
            }
            System.out.println();
        } while(u != 0 || v != 0);
    }

    /* Metoda pro výpočet rovnoběžek a poledníků jednotlivých Marinova zobrazení.*/
    public static double zobrazeniARovnobezky(double r, int u, int m) {
        return r * (Math.toRadians(u)) / m;
    }
    public static double zobrazeniAPoledniky(double r, int v, int m) {
        return r * (Math.toRadians(v)) / m;
    }
    
    /* Metoda pro výpočet rovnoběžek a poledníků jednotlivých Lambertova zobrazení.*/
    public static double zobrazeniLRovnobezky(double r, int u, int m) {
        return r * Math.sin(Math.toRadians(u)) / m;
    }
    public static double zobrazeniLPoledniky(double r, int v, int m) {
        return r * (Math.toRadians(v)) / m;
    }
    
    /* Metoda pro výpočet rovnoběžek a poledníků jednotlivých Braunova zobrazení.*/
    public static double zobrazeniBRovnobezky(double r, int u, int m) {
        return 2 * r * Math.tan(Math.toRadians(u) / 2) / m;
    }
    public static double zobrazeniBPoledniky(double r, int v, int m) {
        return r * (Math.toRadians(v)) / m;
    }
    
    /* Metoda pro výpočet rovnoběžek a poledníků jednotlivých Mercatorova
    zobrazení včetně podmínky pro 90° zeměpisné šířky.*/
    public static double zobrazeniMRovnobezky(double r, int u, int m) {
        if (u == -90 || u == 90) {
            return 1000000;
        } else {
            return r * Math.log(Math.tan((Math.toRadians(u)/2)+Math.toRadians(45))) / m;
        }
    }
    public static double zobrazeniMPoledniky(double r, int v, int m) {
        return r * (Math.toRadians(v)) / m;
    }
    
    /* Metoda pro výpočet rovnoběžek a poledníků jednotlivých Wetchova
    zobrazení včetně podmínky pro 90° zeměpisné šířky.*/
    public static double zobrazeniWRovnobezky(double r, int u, int m) {
        if (u == -90 || u == 90) {
            return 1000000;
        } else {
            return r * Math.tan(Math.toRadians(u)) / m;
        }
    }
    public static double zobrazeniWPoledniky(double r, int v, int m) {
        return r * (Math.toRadians(v)) / m;
    }
    
    /* Metoda pro zaokroulení výsledku na jedno desetinné místo.*/
    public static double zaokrouhli(double cislo, double zaokrouhlovac) {
        return Math.round(cislo * zaokrouhlovac) / zaokrouhlovac;
    }
    
    /* Metoda pro výpis vypočítaných hodnot. V případě hodnoty
    vyšší než 100, respektive nižší než -100, je vypsána pomlčka. V případě
    rovnosti hodnoty 1 000 000 je vypsána věta 'Hodnota není definována'.*/
    public static void vypis(double cislo) {
        if ((cislo > 100 || cislo < -100) && cislo != 1000000) {
            System.out.print("- ");
        } else if (cislo == 1000000){
            System.out.print("Hodnota není definována. ");
        } else {
            System.out.print(cislo + " ");
        }
    }
    
    public static int readInt() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
    }

    public static double readDouble() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }

    public static char readChar() throws IOException {
        Scanner s = new Scanner(System.in);
        return s.next().charAt(0);
    }
}