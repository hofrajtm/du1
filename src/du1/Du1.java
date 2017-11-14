/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
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

        System.out.println("Program pro výpočet souřadnic rovnoběžek a poledníků válcových tečných zobrazení:");
        System.out.println("A - Marinovo");
        System.out.println("L - Lambertovo");
        System.out.println("B - Braunovo");
        System.out.println("M - Mercatorovo");

        System.out.print("Zadejte zobrazení:");
        char z = readChar();
        if (z == 'A' || z == 'L' || z == 'B' || z == 'M') {
        } else {
            System.out.println("Zobrazení bylo zadáno špatně.");
            System.exit(0);
        }

        System.out.print("Zadejte měřítko:");
        int m = readInt();
        if (m > 0) {
        } else {
            System.out.println("Měřítko bylo zadáno špatně.");
            System.exit(0);
        }

        System.out.print("Zadejte poloměr Země:");
        double r = readDouble();
        if (r > 0) {
            r = r * 100000;
        } else if (r == 0) {
            r = 6371.11 * 100000;
        } else {
            System.out.println("Poloměr Země byl zadán špatně.");
            System.exit(0);
        }

        System.out.println("Byly zadány všechny potřebné parametry. Stiskněte Enter pro výpočet!");
        
        double desetinovac = 10;

        if (z == 'A') {
            System.out.print("Rovnoběžky: ");
            for (int u = -90; u <= 90; u = u + 10) {
                vypis(zaokrouhli(r * (Math.toRadians(u)) / m, desetinovac));
            }
            System.out.println();
            System.out.print("Poledníky: ");
            for (int v = -180; v <= 180; v = v + 10) {
                vypis(zaokrouhli(r * (Math.toRadians(v)) / m, desetinovac));
            }
        } else if (z == 'L') {
//            x = r * (Math.toRadians(v)) / m;
//            y = r * Math.sin(Math.toRadians(u)) / m;
//            System.out.println("Rovnoběžky " + y);
//            System.out.println("Poledníky " + x);
        } else if (z == 'B') {
//            x = r * (Math.toRadians(v)) / m;
//            y = 2 * r * Math.tan((Math.toRadians(u)) / 2);
//            System.out.println("Rovnoběžky " + y);
//            System.out.println("Poledníky " + x);
        } else if (z == 'M') {
//            x = r * (Math.toRadians(v)) / m;
//            y = r * Math.log(1.0 / Math.tan((Math.toRadians(w)) / 2));
//            System.out.println("Rovnoběžky " + y);
//            System.out.println("Poledníky " + x);
        } else {
            System.out.println("Vstupní parametry byly zadány špatně!");
        }

        // TODO code application logic here
    }
    
    public static double zaokrouhli(double cislo, double zaokrouhlovac) {
        return Math.round(cislo * zaokrouhlovac) / zaokrouhlovac;
    }
    
    public static void vypis(double cislo) {
        if (cislo > 100 || cislo < -100) {
            System.out.print("- ");
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
