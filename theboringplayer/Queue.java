/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author holo7
 */
public class Queue {

    ArrayList<Track> tracksInQueue = new ArrayList<Track>();

    Queue() {

    }

    public void addToQueue(Track track) {
        tracksInQueue.add(track);
    }

    public void addNextInQueue(Track track) {
        tracksInQueue.add(1, track);
    }

    public void removeFromQueue(int index) {
        tracksInQueue.remove(index);
    }

    public ArrayList<Track> getTracksInQueue() {
        return tracksInQueue;
    }

    public void shuffleQueue() {
        Collections.shuffle(tracksInQueue);
    }

}
