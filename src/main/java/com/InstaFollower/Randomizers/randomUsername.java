package com.InstaFollower.Randomizers;

import java.util.*;

public class randomUsername {
    public static String randomUsername() {
        // get a bunch of lastnames in a map of random index of a map with value being random ints from 1-10000 and lastnames being values
        // concat lastnames based on some sort of random arrangement
        // add ints random as well maybe sometimes maybe not

        Map<Integer, String> map = new HashMap<Integer, String>();
        List<String> list = new ArrayList<>();
        Random r = new Random();
        String finalName = "";

        list.add("Charles");
        list.add("Smith");
        list.add("Johnson");
        list.add("Williams");
        list.add("Brown");
        list.add("Jones");
        list.add("Garcia");
        list.add("Miller");
        list.add("Davis");
        list.add("West");
        list.add("Bogie");
        list.add("boogy");
        list.add("aboogie");
        list.add("Ruger");
        list.add("Ghost");
        list.add("Patrice");
        list.add("Karen");
        list.add("Corinne");
        list.add("Greg");
        list.add("Jack");
        list.add("Dom");
        list.add("Kate");
        list.add("Snicks");
        list.add("Leyton");
        list.add("Paradise");
        list.add("Waterloo");
        list.add("Cambridge");
        list.add("Liam");
        list.add("Noah");
        list.add("Oliver");
        list.add("Amelia");
        list.add("Charlotte");
        list.add("Emma");
        list.add("Olivia");
        list.add("Isabella");
        list.add("A$apRocky");
        list.add("ASAPMob");
        list.add("Prince");


        for(int i=0; i<list.size(); i++) {
            map.put(i, list.get(i));
        }

        int randomMapKey = r.nextInt((list.size()-1)+1);
        boolean randomConcatBoolean = r.nextBoolean();
        boolean randomStrToInt = r.nextBoolean();
        String randomname = map.get(randomMapKey);
        String concatName = map.get(r.nextInt((list.size()-1)+1));

        if(randomConcatBoolean) {
            finalName = randomname + concatName;
        }
        else {
            finalName = randomname;
        }

        if(randomStrToInt) {
            for(int j = 0; j<finalName.length(); j++) {
                if(finalName.charAt(j) == 'i' || finalName.charAt(j) == 'I') {
                    finalName = finalName.substring(0, j) + '1' + finalName.substring(j + 1);
                }
                if(finalName.charAt(j) == 's' || finalName.charAt(j) == 'S') {
                    finalName = finalName.substring(0, j) + '$' + finalName.substring(j + 1);
                }
            }
        }

        return finalName;
    }
}
