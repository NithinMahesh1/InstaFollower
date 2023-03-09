package com.InstaFollower;

// Bot imports
import com.InstaFollower.EmailBot.EmailBot;
import com.InstaFollower.InstaBot.InstaBot;

// Selenium Imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

/*
    Created Users:

    bangarang99neighbors@tutanota.com
    bmwM5csdroptop1$

    Jackthebeaniemeanie4@tutanota.com
    a$apt1lldeathofme

    nohesi
    nohe$1cutuP


    2_28_2023 - First successful emailbot created fully automated
        * This is the user: bangarang99neighbors password: bmwM5csdroptop1$
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String username = randomUsername();
        String password = randomPassword();
        String firstname = "DavidSmith";
        String lastname = "Garcia";
        String month = "12";
        String day = "13";
        String year = "1999";


        // Define the path to the chrome webdriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\java\\com\\WebDriver\\chromedriver-110-0-5481-77.exe");
        WebDriver driver = new ChromeDriver();

        // Initialize both bots
        EmailBot EmailBot1 = new EmailBot(username,password,driver);
        InstaBot InstaBot1 = new InstaBot(username,password,firstname,lastname,day,month,year,driver,EmailBot1);

        // Run the bots (at the moment only one at a time)
//        EmailBot1.runEmailBot();
//        InstaBot1.runInstaBot();
    }


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

    public static String randomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        int randomLength = r.nextInt((12-1)+1);

        Random random = new Random();
        char[] password = new char[randomLength];
        for (int i = 0; i < randomLength; i++) {
            password[i] = characters.charAt(random.nextInt(characters.length()));
        }

        return new String(password);
    }
}
