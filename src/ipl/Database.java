package ipl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Database {

    public HashMap<Integer, ArrayList> databaseMatches() throws Exception {

        FileReader fr = new FileReader("/home/milan/Downloads/ipl/matches.csv");
        ArrayList year = new ArrayList<>();
        HashMap<Integer, ArrayList> Database = new HashMap<Integer, ArrayList>();
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


    public HashMap<Integer, ArrayList> databaseDeliveries() throws Exception {

        FileReader fr = new FileReader("/home/milan/Downloads/ipl/deliveries.csv");
        ArrayList year = new ArrayList<>();
        HashMap<Integer, ArrayList> Database = new HashMap<Integer, ArrayList>();
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
