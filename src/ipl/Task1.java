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
       Map<Integer,ArrayList> map=d.databaseMatches();
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
        Map<Integer,ArrayList> map=d.databaseMatches();
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
    public void GetExtraRunsByTeam() throws Exception{

        Database d=new Database();
        Map<Integer,ArrayList> matches=d.databaseMatches();
        Map<Integer,ArrayList> deliveries=d.databaseDeliveries();
        ArrayList<String> matcherIdOf2016=new ArrayList<String>();

        TreeMap<String,Integer> ExtraRunsByTeam=new TreeMap<String,Integer>();

        String s="2016";
        for(Map.Entry<Integer,ArrayList> m: matches.entrySet())
        {
            String t= matches.get(m.getKey()).get(1)+"";
            if(t.equals(s))
            {

                String t2=matches.get(m.getKey()).get(0)+"";
                matcherIdOf2016.add(t2);
            }

        }

        for(Map.Entry<Integer,ArrayList> del: deliveries.entrySet())
        {

            if(matcherIdOf2016.contains(deliveries.get(del.getKey()).get(0)))
            {

                if(!ExtraRunsByTeam.containsKey(deliveries.get(del.getKey()).get(2)))
                {
                    int sum=Integer.parseInt(deliveries.get(del.getKey()).get(16).toString());

                    ExtraRunsByTeam.put(deliveries.get(del.getKey()).get(2).toString(),sum);
                }
                else{

                    int sum2=ExtraRunsByTeam.get(deliveries.get(del.getKey()).get(2).toString())+
                            Integer.parseInt(deliveries.get(del.getKey()).get(16).toString());
                    ExtraRunsByTeam.put(deliveries.get(del.getKey()).get(2).toString(),sum2);

                }

            }

        }
        System.out.println(ExtraRunsByTeam);




    }





}


