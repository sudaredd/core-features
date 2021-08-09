package designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(String message);
}

class EventSource {
    private List<Observer> observers = new ArrayList<>();

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals("exit"))
                break;
            notifyObservers(line);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {

        EventSource eventSource = new EventSource();
        eventSource.addObserver(message-> System.out.println("alerted message for observer1: "+message));
        eventSource.addObserver(message-> System.out.println("alerted message for observer2: "+message));
        eventSource.addObserver(message-> System.out.println("alerted message for observer3: "+message));

        eventSource.scanSystemIn();
    }
}
