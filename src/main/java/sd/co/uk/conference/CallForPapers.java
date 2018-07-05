package sd.co.uk.conference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sd.co.uk.domain.Talk;

public class CallForPapers {

    static ArrayList<Talk> acceptedTalks = new ArrayList<Talk>();
    
    /**
     * Submit talks from a given file
     * 
     * @param file
     * @return
     * @throws Exception
     */
    public static ArrayList<Talk> submitTalks(File file) throws Exception {
        if (file.exists()) {
            try {
                String talkSubmissionToProcess = "";
                BufferedReader b_reader = new BufferedReader(new FileReader(file));
                while ((talkSubmissionToProcess = b_reader.readLine()) != null) {
                    talkSubmissionToProcess = talkSubmissionToProcess.trim();
                    try {
                        acceptedTalks = ConferenceCommittee
                                .acceptTalkSubmission(talkSubmissionToProcess, acceptedTalks);
                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                throw new Exception("Could not read file - " + file.getPath());

            }

            return acceptedTalks;
        } else {
            throw new Exception("File cant be found - " + file.getPath());
            }
    }


    /**
     * Submit talks from terminal
     * 
     * @return ArrayList<Talk>
     */
    public static ArrayList<Talk> submitTalks() {
        Scanner scanner = new Scanner(System.in);

        boolean hasNext = true;
        while (hasNext) {

            String line = scanner.nextLine();
            line = line.trim();
            if (line.isEmpty()) {
                hasNext = false;
                break;
            } else {
                try {
                    acceptedTalks = ConferenceCommittee.acceptTalkSubmission(line, acceptedTalks);
                } catch (Exception e) {
                }
            }
        }
        scanner.close();

        return acceptedTalks;

    }


}
