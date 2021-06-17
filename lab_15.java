package com.example.helloworld;
import java.util.ArrayList;
import java.util.List;

public class lab_15 {

    public static void main(String[] args) {
        System.out.println("🎇🎇🎇🎇Subscribes info🎇🎇🎇🎇");
        Community com = new Community();
        Follower db = new Follower(com);

        com.changeData(101, "wild nature");
        com.changeData(202, "easy cooking");
        com.changeData(606, "lazy bones");
    }
}
interface Notifier{
    void addObserver(Observer obs);
}

class Community implements Notifier{
    private List observers;
    private int Num;
    private String name;


    public Community(){
        observers = new ArrayList();
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++){
            Observer obs = (Observer)observers.get(i);
            obs.update(Num, name);
        }
    }
    public void changeData(int Num, String name){
        this.Num = Num;
        this.name = name;
        notifyObserver();
    }
}
interface Observer{
    void update(int Num, String name);
}


class Follower implements Observer{
    private Notifier notifier;
    private int Num;
    private String name;

    public Follower(Notifier notifier){
        this.notifier = notifier;
        notifier.addObserver(this);
    }
    public void update(int Num, String name) {
        this.Num = Num;
        this.name = name;
        show();
    }
    public void show(){
        System.out.println("Public '" + name +"' number of subs " + Num);
    }
}

