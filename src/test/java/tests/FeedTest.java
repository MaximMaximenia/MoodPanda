package tests;

import org.testng.annotations.Test;

public class FeedTest extends BaseTest {

    @Test
    public void hugTest() {
        mainSteps.login("maxigh@mail.sd", "2222222");

        feedPage
                .toWorldFeedPage()
                .hugByIntAndValidation(2);
    }
}

