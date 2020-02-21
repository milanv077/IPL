package ipl;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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

                if(!ExtraRunsByTeam.containsKey(deliveries.get(del.getKey()).get(3)))
                {
                    int sum=Integer.parseInt(deliveries.get(del.getKey()).get(16).toString());

                    ExtraRunsByTeam.put(deliveries.get(del.getKey()).get(3).toString(),sum);
                }
                else{

                    int sum2=ExtraRunsByTeam.get(deliveries.get(del.getKey()).get(3).toString())+
                            Integer.parseInt(deliveries.get(del.getKey()).get(16).toString());
                    ExtraRunsByTeam.put(deliveries.get(del.getKey()).get(3).toString(),sum2);

                }

            }

        }
        System.out.println(ExtraRunsByTeam);




    }

    public void EconomicalBowler() throws  Exception{

        Database d=new Database();
        LinkedHashMap<Integer,ArrayList> deliveries=d.databaseDeliveries();
        HashMap<String,Integer> overCount=new LinkedHashMap<String,Integer>();
        HashMap<String,Integer> totalRun=new LinkedHashMap<String,Integer>();
        Map<Integer,ArrayList> matches=d.databaseMatches();
        ArrayList<String> matcherIdOf2015=new ArrayList<String>();

        String s="2015";
        for(Map.Entry<Integer,ArrayList> m: matches.entrySet())
        {
            String t= matches.get(m.getKey()).get(1)+"";
            if(t.equals(s))
            {

                String t2=matches.get(m.getKey()).get(0)+"";
                matcherIdOf2015.add(t2);
            }

        }



        String prev="";
        String current="";
        for(Map.Entry<Integer,ArrayList> del: deliveries.entrySet()) {
            if (matcherIdOf2015.contains(deliveries.get(del.getKey()).get(0))) {

                current = deliveries.get(del.getKey()).get(8).toString();

                if (!prev.equals(current)) {
                    prev = current;
                    if (!overCount.containsKey(current)) {
                        overCount.put(current, 1);
                    } else {
                        overCount.put(current, overCount.get(current) + 1);
                    }


                }
                if (!totalRun.containsKey(current)) {
                    int sum = Integer.parseInt(deliveries.get(del.getKey()).get(17).toString());
                    totalRun.put(current, sum);
                } else {

                    int sum2 = totalRun.get(current) + Integer.parseInt(deliveries.get(del.getKey()).get(17).toString());
                    totalRun.put(current, sum2);

                }
            }
        }


        HashMap<String,Float> average=new LinkedHashMap<String,Float>();

        for(Map.Entry<String, Integer> ave:overCount.entrySet())
        {
            float a=(float)totalRun.get(ave.getKey())/overCount.get(ave.getKey());
            average.put(ave.getKey(),a);
        }


        Float max=Float.MAX_VALUE;
        String bowlerName="";
        for (Map.Entry<String,Float> min:average.entrySet())
        {
            if(max>average.get(min.getKey()))
            {
                max=average.get(min.getKey());
                bowlerName=min.getKey();
            }
        }
        System.out.println(bowlerName+" "+max);


    }

}


