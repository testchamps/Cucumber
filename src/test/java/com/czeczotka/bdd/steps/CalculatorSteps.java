package com.czeczotka.bdd.steps;

import com.czeczotka.bdd.calculator.Calculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorSteps {

    private Calculator calculator;
    
    Element root=new Element("Results_Cucumber");
    Document doc=new Document();

    Element child1=new Element("TestCase1");
    child1.addContent("Passed");
    Element child2=new Element("TestCase2");
    child1.addContent("Passed");
    Element child3=new Element("TestCase3");
    child3.addContent("Passed");

    root.addContent(child1);
    root.addContent(child2);
    root.addContent(child3);

    doc.setRootElement(root);

    XMLOutputter outter=new XMLOutputter();
    outter.setFormat(Format.getPrettyFormat());
    outter.output(doc, new FileWriter(new File("testResults_Cucumber.xml")));
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        assertNotNull(calculator);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void i_add_and(int arg1, int arg2) throws Throwable {
        calculator.add(arg1, arg2);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int result) throws Throwable {
        assertEquals(result, calculator.getResult());
    }
}
