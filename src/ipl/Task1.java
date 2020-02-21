package ipl;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task1  {



    public void FindTotalMatchesPerYear() throws Exception {

       Database d=new Database();
       Map<Integer,ArrayList> map=d.database();
       TreeMap<String,Integer> Matches=new TreeMap<String,Integer>();

    for(Map.Entry<Integer,ArrayList> v:map.entrySet())
        {
            if(!Matches.containsKey(map.get(v.getKey()).get(1).toString()))
            {
                Matches.put(map.get(v.getKey()).get(1).toString(),1);
            }
            else
            {
                Matches.put(map.get(v.getKey()).get(1).toString(),Matches.get(map.get(v.getKey()).get(1).toString())+1);
            }
        }
        System.out.println(Matches);
    }


    public  void MatchesWonByTeam() throws Exception {
        Database d=new Database();
        Map<Integer,ArrayList> map=d.database();
        TreeMap<String,Integer> WonTeam=new TreeMap<String,Integer>();

        for(Map.Entry<Integer,ArrayList> v:map.entrySet())
        {

                if (!WonTeam.containsKey(map.get(v.getKey()).get(10).toString())) {
                    WonTeam.put(map.get(v.getKey()).get(10).toString(), 1);
                } else {
                    WonTeam.put(map.get(v.getKey()).get(10).toString(), WonTeam.get(map.get(v.getKey()).get(10).toString()) + 1);
                }

        }
        WonTeam.remove("");
        System.out.println(WonTeam);




    }




}


