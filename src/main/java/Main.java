package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static String time_regex = ".*[1-9]min";
    // reads in a list of talks and print out the track lists
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Talk> talkList = new ArrayList<Talk>();
        boolean hasNext = true;
        while (hasNext) {
            Talk talk;
            String line = scanner.nextLine();
            line = line.trim();
            if (line.isEmpty()) {
                hasNext = false;
                break;
            }
            else {
                if (line.contains("lightning")) {
                    talk = new Talk(line, 5);
                    talkList.add(talk);

                } else if (line.contains("min")) {

                    String title = line.substring(0, line.length() - 5);
                    title = title.trim();
                    int time =
                            Integer.parseInt(line.substring(title.length(), line.length() - 3));
                    talk = new Talk(title, time);
                    talkList.add(talk);

                } else {
                    System.out.println("cant organise talk - " + line);
                }
            }

        }
        scanner.close();

        Conference conference = new Conference();

        ArrayList<Track> trackList = new ArrayList<Track>();
        try {
            trackList = conference.scheduleTalks(talkList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (null != trackList) {
            for (Track track : trackList) {
                System.out.println(track.toString());
            }
        }

    }

}
