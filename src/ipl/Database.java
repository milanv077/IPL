package ipl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Database {

    public LinkedHashMap<Integer, ArrayList> databaseMatches() throws Exception {

        FileReader fr = new FileReader("matches.csv");
        ArrayList year = new ArrayList<>();
        LinkedHashMap<Integer, ArrayList> Database = new LinkedHashMap<Integer, ArrayList>();
        BufferedReader br = new BufferedReader(fr);
        String t1 = br.readLine();
        String t = "";
        int i = 1;
        while ((t = br.readLine()) != null) {
            String y[] = t.split(",");
            ArrayList al = new ArrayList(Arrays.asList(y));
            Database.put(i, al);
            i++;
        }

        return Database;
    }


    public LinkedHashMap<Integer, ArrayList> databaseDeliveries() throws Exception {

        FileReader fr = new FileReader("deliveries.csv");
        ArrayList year = new ArrayList<>();
        LinkedHashMap<Integer, ArrayList> Database = new LinkedHashMap<Integer, ArrayList>();
        BufferedReader br = new BufferedReader(fr);
        String t1 = br.readLine();
        String t = "";
        int i = 1;
        while ((t = br.readLine()) != null) {
            String y[] = t.split(",");
            ArrayList al = new ArrayList(Arrays.asList(y));
            Database.put(i, al);
            i++;
        }

        return Database;
    }
}
