package testRunner;

import com.intuit.karate.junit5.Karate;


public class TestRunner {

    String project_path = System.getProperty("user.dir").toString() ;

    @Karate.Test
    Karate testSample() {
        return Karate.run(project_path+"/src/test/Feature_Files/Pet_Validation.feature");

    }
}
