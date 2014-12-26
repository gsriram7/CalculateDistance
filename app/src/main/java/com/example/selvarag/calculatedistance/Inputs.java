package com.example.selvarag.calculatedistance;

import java.util.ArrayList;

/**
 * Created by selvarag on 12-12-2014.
 */
public class Inputs {
    private ArrayList<String> locs;
    String source;

    public Inputs(){
        source = "10.1556200,76.48910298";      //Replace this with actual source from server
        //Sample location data for 5 members
        String[] data = {"10.1556200,76.2781029","10.1556200,76.2331029","10.1556200,76.2891029","10.0954200,76.2891029","10.0914200,76.3891029"};
        locs = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            locs.add(data[i]);                  //Replace this with location of all the participants
        }
    }

    public String getSource(){
        return source;
    }

    public ArrayList<String> getLocs(){
        return locs;
    }

    public String[] getNames(int i){
        //Return the respective participant's name or retrieve his info from contacts or anything
        return null;
    }
}
