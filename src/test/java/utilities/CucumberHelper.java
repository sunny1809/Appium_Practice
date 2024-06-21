package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.cucumber.datatable.DataTable;
import stepDefinitions.Base;

public class CucumberHelper extends Base {
	
	public ArrayList<List<String>> prepareLists(DataTable calcTable) {
		ArrayList<List<String>> calcData = new ArrayList<List<String>>();
		List<String> methodList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();
		
		String method = "";
		String number = "";
		for (Map<String, String> data : calcTable.asMaps(String.class, String.class)) {

			method = data.get("Methods");
			methodList.add(method);
			
			number = data.get("Numbers");
			numberList.add(number);
					
		}
		calcData.add(numberList);
		calcData.add(methodList);
		return calcData;
	
	}

	public void performCalculation(List<String> numberList, List<String> methodList) {
		System.out.println("Numbers: " + numberList);
		System.out.println("Methods: " + methodList);
		for (int i=0; i<numberList.size(); i++) {
			
			String numberStr = numberList.get(i);
			for (int j = 0; j < numberStr.length(); j++) {
				char numberChar = numberStr.charAt(j);
				clickDigits(String.valueOf(numberChar));

			}
			
			
			String method = methodList.get(i);
			if (method.toLowerCase().equals("na"))
				break;
			else
				clickMethods(method);
			
		}
		
	}

	public void clickDigits(String digit) {
		WebElement clickBtn = driver.findElement(AppiumBy.accessibilityId(digit));
		clickBtn.click();
		System.out.println("Clicked " + digit);

		if (digit.equals(".")) {
			WebElement clickDec = driver.findElement(AppiumBy.accessibilityId("point"));
			clickDec.click();
			System.out.println("Clicked " + digit);
		}
	}

	public void clickMethods(String method) {
		WebElement clickOption = driver.findElement(AppiumBy.accessibilityId(method));
		clickOption.click();
		System.out.println("Clicked " + method);

	}

	public String grabResult() {
		WebElement clickEqual = driver.findElement(AppiumBy.accessibilityId("equals"));
		clickEqual.click();
		System.out.println("Clicked equals");

		WebElement clickResultArea = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
		String actualResult = clickResultArea.getText();
		System.out.println("Actual Result : " + actualResult);
		return actualResult;

	}

}
