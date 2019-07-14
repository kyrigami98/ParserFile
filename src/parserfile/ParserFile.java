package parserfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ParserFile {

    public ParserFile() {
        //constructeur
    }

//********************************************************************************************************
    public static void main(String[] args) throws IOException {

        /* System.out.println("Choisissez un fichier a parser : \n");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        System.out.print("\n");
         */
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Your current relative path is: " + s);

        String file = "E:\\MySpace\\COURS_MASTER\\clean_code\\ParserFile\\src\\parserfile\\test.txt";
        String log = "E:\\MySpace\\COURS_MASTER\\clean_code\\ParserFile\\src\\parserfile\\log.txt";
        Parser(file, log);
        AfficherParsedFile(log);

    }
//********************************************************************************************************

    public static void Parser(String file, String log) {

        System.out.print("Parsage de " + file + " en cours... \n");
        try {
            InputStream flux = new FileInputStream(file);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            String result = Verify(Lecture(buff));
            enregister(result, log);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
//********************************************************************************************************

    public static String[] Lecture(BufferedReader buff) throws IOException {

        System.out.print("Lecture du fichier en cours... \n");
        String ligne;
        String[] format;
        format = new String[10];
        for (int i = 0; i < 9; i++) {
            format[i] = "";
        }
        
        while ((ligne = buff.readLine()) != null) {

            System.out.println(ligne);
            int h = 0;
            for (int k = 0; k < 9; k++) {
                format[k] += ligne.substring(h, h + 3);
                h = h + 3;
            }
        }
        buff.close();
        System.out.print("\n");
        return format;

    }
//********************************************************************************************************

    public static void AfficherParsedFile(String log) throws IOException {

        try {
            InputStream flux = new FileInputStream(log);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            System.out.print("Voici le contenu du fichier de log: " + log + " \n");
            String ligne;
            while ((ligne = buff.readLine()) != null) {
                System.out.println(ligne);
            }
            buff.close();
            System.out.print("\n");

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
//********************************************************************************************************

    public static String Verify(String format[]) {

        String map[] = {"     |  |", " _  _||_ ", " _  _| _|", "   |_|  |", " _ |_  _|",
            " _ |_ |_|", " _   |  |", " _ |_||_|", " _ |_| _|"};

        System.out.print("verification en cours... \n");
        String result = "";
        boolean Trouver = false;
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (format[j].equals(map[i]) && Trouver == false) {
                    result += Integer.toString(i + 1);
                     Trouver = true;
                } else {
                    Trouver = false;
                }
            }
        }
        System.out.print("Parsage terminé! \n");
        return result;
    }
//********************************************************************************************************

    public static void Afficher(String result) {

        System.out.print(result);
        System.out.print("\n");

    }
//********************************************************************************************************

    public static void enregister(String result, String filename) throws IOException {

        if (!"".equals(result)) {
            File logFile = new File(filename);
            try (PrintWriter out = new PrintWriter(new FileWriter(logFile))) {
                out.write(result + " | " + cheksum(result)); //écris le resultat dans le fichier
                out.println(); //fais un retour à la ligne dans le fichier 
                System.out.print("Enregistrement reussi! \n");
            } catch (Exception e) {
            }
        }

    }
//********************************************************************************************************

    public static String cheksum(String result) {
        Integer check;
        check= 0;
        int count = 8;
        for (int i = 0; i < 9; i++) {
            check += (i + 1) * (Integer.parseInt(String.valueOf(result.charAt(8 - i))));
        }
        System.out.print("Cheksum = " + (check % 11) + "\n");
        if (check % 11 == 0) {
            return "";
        } else {
            return "ERR";
        }

        //((1p1) + (2p2) + (3p3) + ... + (9p9)) mod 11 == 0
    }
//********************************************************************************************************

}
