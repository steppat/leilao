package br.com.alura.leilao.e2e.acceptance;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//junit4
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
	plugin = {"pretty", "html:target/cucumber.html"},
	tags = "@lance or @login")
public class LeilaoCucumberAcceptanceTest {

}
 