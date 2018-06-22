package sd.co.uk.conference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.conference.ConferenceCommittee;
import sd.co.uk.conference.Main;
import sd.co.uk.domain.Talk;

public class MainTest {

    String testFile;

    @Before
    public void setUp() throws Exception {
        testFile = "./src/test/java/resources/TestInput.txt";

    }

    // test to check reading input from file
    @Test
    public void testFileReading() throws Exception {
        String[] args = new String[1];
        args[0] = testFile;
        Main.main(args);

    }

    // test to check exception is thrown if input file cant be found
    @Test(expected = Exception.class)
    public void givenThatFileDoesNotExistThrowException() throws Exception {
        String[] args = new String[1];
        args[0] = testFile + "test";

    try{
            Main.main(args);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "File cant be found - " + testFile + "test");
            throw e;
        }
        fail("Exception not thrown");

    }

    // test to check exception is thrown if not enough talks for conference
    @Test(expected = Exception.class)
    public void testOrganiseTalkExceptionTrown() throws Exception {
        // single talk should throw exception
        String title = "Single Talk";
        try{
            
            ConferenceCommittee.organiseTalk(title, new ArrayList<Talk>());
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Cant organise talk - " + title);
            throw e;
        }
        fail("Exception not thrown");

    }


}
