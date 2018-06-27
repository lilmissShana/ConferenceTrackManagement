package sd.co.uk.conference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.conference.ConferenceCommittee;
import sd.co.uk.conference.Main;
import sd.co.uk.domain.Talk;

// TODO: the aim is that the tests in this class are very few, because that means you've pulled encapsulated things nicely
public class MainTest {

    String testFile;

    @Before
    public void setUp() throws Exception {
        testFile = "./src/test/java/resources/TestInput.txt";

    }

    // TODO: Remove this comment, as the test name will tell you what you need to know: "test to check reading input from file"
    @Test
    public void testFileReading() throws Exception {
        String[] args = new String[1];
        args[0] = testFile;
        Main.main(args);

    }

    // TODO: Remove this comment, as the test name will tell you what you need to know: "test to check exception is thrown if input file cant be found"
    @Test(expected = Exception.class)
    public void givenThatFileDoesNotExistThrowException() throws Exception {
        String[] args = new String[1];
        args[0] = testFile + "test";

    try{
            Main.main(args);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "File cant be found - " + testFile + "test"); // TODO: check spelling in assertion messages
            throw e;
        }
        fail("Exception not thrown");

    }

    // TODO: Remove this comment, as the test name will tell you what you need to know: "test to check exception is thrown if inot enough talks for conference"
    // test to check exception is thrown if not enough talks for conference
    @Test(expected = Exception.class)
    public void testOrganiseTalkExceptionTrown() throws Exception {
        // single talk should throw exception
        String title = "Single Talk";
        try{
            
            ConferenceCommittee.organiseTalk(title, new ArrayList<Talk>());
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Cant organise talk - " + title); // TODO: check spelling in assertion messages
            throw e;
        }
        fail("Exception not thrown");

    }


}
