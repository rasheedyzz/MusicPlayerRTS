/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.util.ArrayList;

/**
 *
 * @author holo7
 */
public final class Library extends Thread {

    static ArrayList<Track> Tracks = new ArrayList<Track>();
    ArrayList<Playlist> Playlists = new ArrayList<Playlist>();
    String MusicSourcePath;

    Library(String musicSourcePath) {
        MusicSourcePath = musicSourcePath;
        Fetcher fetcher = new Fetcher(MusicSourcePath);
        initalizeLibrary(fetcher.paths);
    }
    
     @Override
    public void run() {
            try {
                
                Fetcher fetcher = new Fetcher(MusicSourcePath);
                checkNewSongs(Tracks, fetcher.paths);
                Thread.sleep(10000);
                
            } catch (Exception e) {
                
                System.out.println("Something wrong happened with the music thread.");
                e.printStackTrace();
            }
    }

    public ArrayList<Track> getListOfTracks() {
        return Tracks;
    }

    public void printListOfTracks() {
        if (Tracks.isEmpty()) {
            System.out.printf("Library is empty!");
        } else {
            System.out.println(Tracks.toString());
        }
    }

    public String Search(String trackName) {
        String TrackN = null;
        if (Tracks.contains(trackName)) {
            TrackN = trackName;
        } else {
            System.out.println("The song is not in the library");
            TrackN = null;
        }

        return TrackN;
    }

    public void initalizeLibrary(ArrayList<String> pathsFromFetcher) {

        if (Tracks.isEmpty()) {
            System.out.println("Adding new songs...");
            for (int i = 0; i < pathsFromFetcher.size(); i++) {
                Track newTrack = new Track(pathsFromFetcher.get(i));
                Tracks.add(newTrack);
                if (!Tracks.isEmpty()) {
                    System.out.println("Added " + newTrack.getPath());
                } else {
                    System.out.println("Problem occured. Couldn't add song.");
                }
            }
        } else {

            System.out.println("Liberary already initialized. Checking for new songs...");
            checkNewSongs(Tracks, pathsFromFetcher);
        }

    }

    public void checkNewSongs(ArrayList<Track> Tracks, ArrayList<String> paths) {

        for (int j = 0; j < paths.size(); j++) {
            for (int i = 0; i < Tracks.size(); i++) {

                if (Tracks.get(i).path.equals(paths.get(j))) {
                    System.out.printf("Same ol' Songs, nothing new.");
                } else {
                    Track x = new Track(paths.get(j));
                    Tracks.add(x);
                    System.out.println(Tracks.toString() + "Damn, that's good");

                }

            }

        }

    }
}
