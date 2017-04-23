package com.spbstu.webMantis;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by anna on 22.04.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/resources/features"},
        glue = {"com.spbstu.webMantis.stepDefs"}
)
public class Runner {

}
