package com.ucsal;

public class Process {
    Event[] events;

    public Process(int numberOfEvents) {
        events = new Event[numberOfEvents];
        for (int i = 0; i < numberOfEvents; i++) {
            events[i] = new Event(i + 1);
        }
    }
}
