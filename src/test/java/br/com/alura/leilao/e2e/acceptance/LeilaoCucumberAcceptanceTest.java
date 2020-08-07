package br.com.alura.leilao.e2e.acceptance;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//junit4
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", 
	tags = "@leilao")
public class LeilaoCucumberAcceptanceTest {

}
 