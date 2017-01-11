package src.test.java.com.qait.AKC.Smoke.tests;

import static com.qait.quia2.automation.utils.YamlReader.getData;
import org.testng.annotations.Test;
import com.qait.quia2.automation.TestSessionInitiator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Archit
 */
public class AppBuilder_Test {

    TestSessionInitiator test;

    @BeforeMethod
    public void LaunchAndLoginApplication() {
        test = new TestSessionInitiator("Brain_Login_StudentTests");
        test.launchApplication(getData("ABURL"));
        test.loginpage.login_to_the_application_as(getData("users.username"), getData("users.password"));
    }

    @Test
    public void Test01_Navigating_to_AKC_Build() {
        test.abcanvas.clicking_platform("MindTap");
        test.abcanvas.clicking_artifact("ActivityBuilder");
        test.abcanvas.clicking_Edit_Platform();
        test.abcanvas.clicking_Foundation_Setting();
        test.abcanvas.clicking_Artifact("assessment-builder");
        test.abcanvas.fetching_current_build();
    }

    @Test
    public void Test02_Navigating_to_DevMath_Build() {
        test.abcanvas.clicking_platform("DevStudies");
        test.abcanvas.clicking_artifact("DevStud-Math");
        test.abcanvas.clicking_Edit_Platform();
        test.abcanvas.clicking_Foundation_Setting();
        test.abcanvas.print("QA Builds");
        test.abcanvas.clicking_Artifact("cengage-devmath");
        test.abcanvas.fetching_current_build();
        test.abcanvas.selecting_Label("UUID: 4");
        test.abcanvas.clicking_Artifact("clue-aggregator-server");
        test.abcanvas.fetching_current_build();
        test.abcanvas.selecting_Label("UUID: 5");
        test.abcanvas.clicking_Artifact("clue-dev-math-course-editor");
        test.abcanvas.fetching_current_build();
        test.abcanvas.click_Cancel();
        test.abcanvas.select_environment();
        test.abcanvas.clicking_Edit_Platform();
        test.abcanvas.clicking_Foundation_Setting();
        test.abcanvas.print("STAGE Builds");
        test.abcanvas.clicking_Artifact("cengage-devmath");
        test.abcanvas.fetching_current_build();
        test.abcanvas.selecting_Label("UUID: 4");
        test.abcanvas.clicking_Artifact("clue-aggregator-server");
        test.abcanvas.fetching_current_build();
        test.abcanvas.selecting_Label("UUID: 5");
        test.abcanvas.clicking_Artifact("clue-dev-math-course-editor");
        test.abcanvas.fetching_current_build();
    }

    @AfterMethod
    public void closeSession() {
        test.closeTestSession();
    }

}
