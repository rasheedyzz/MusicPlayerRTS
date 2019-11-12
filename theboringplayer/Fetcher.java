/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author holo7
 */
public class Fetcher {

    String folderPath;
    ArrayList<String> paths = new ArrayList<String>();
    
    Fetcher(String FolderPath)
    {
        folderPath = FolderPath;
        retrieveSongs(folderPath);
        
    }
    
    public ArrayList<String> getFilesPaths()
    {
        System.out.println(paths.toString());
        return paths;
    }

    public void retrieveSongs(String folderPath) {
        File f = new File(folderPath);
        
        try {

            for (File x : f.listFiles()) {
                if (x == null) {
                    return;
                }
                if (x.isHidden() || !x.canRead()) {
                    continue;
                }
                if (x.isDirectory()) {
                    retrieveSongs(x.getPath());
                } else if (x.getName().endsWith(".mp3")) {
                    paths.add(x.getPath());
                }

            }
        } catch (Exception e) {
        }

        System.out.println("Fetching completed. Found " + paths.size() + " song / songs.");
    }

}
