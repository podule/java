package ru.podule.lthree;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private String fullName;
    private ArrayList<String> phone = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();

    private HashMap<String, Phonebook> mapPhone = new HashMap<>();


    public Phonebook() {
    }

    public Phonebook(String fullName, String phone, String email) {
        this.fullName = fullName;
        this.phone.add(phone);
        this.email.add(email);

    }


    public void add(String fullName, String phone, String email){
        Phonebook phonebook;
        if(mapPhone.containsKey(fullName)){
            phonebook = mapPhone.get(fullName);
            phonebook.phone.add(phone);
            phonebook.email.add(email);

        }else{
            phonebook = new Phonebook(fullName, phone, email);
        }
        mapPhone.put(phonebook.fullName, phonebook);
    }

    public String get(String fullName){

        Phonebook pb = mapPhone.get(fullName);

        return pb.phone.toString();
    }


}
