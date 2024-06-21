package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.CucumberHelper;

public class Calculator extends Base {
	
	CucumberHelper helper = new CucumberHelper();
	
	@Given("Perform methods with numbers")
	public void execute_method(DataTable calcTable) {
		
		System.out.println("Reading data...");
		ArrayList<List<String>> calcData = helper.prepareLists(calcTable);
		
		List<String> numberList = calcData.get(0);	    
	    List<String> methodList = calcData.get(1);;
	    
	    helper.performCalculation(numberList, methodList);
	}
	
	@Then("Verify the result {string}")
	public void verify_the_result(String expectedResult) {
	    String actualResult = helper.grabResult();
	    System.out.println("Expected Result : " + expectedResult);
	    
	    Assert.assertEquals(expectedResult, actualResult);
	    System.out.println("Assertion passed");
	    
	}

}
