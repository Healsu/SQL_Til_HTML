package com.example.sql_til_html.services;

public class CheckMail {
    private String userInput;


    public static boolean checkIfMail(String userInput){


        while (userInput.contains("@")){
            if(userInput.contains(".dk") || userInput.contains(".com")){
                return true;
            }else{
                System.out.println("Bruh den mail har ingen bitches");
                return false;
            }
        }

        return false;
    }
}
