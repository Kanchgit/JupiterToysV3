package PageObjects.Jupiter;

import org.openqa.selenium.WebElement;

import PageObjects.Functions.ControlFunctions;

public class ContactPage extends ControlFunctions {
	String contactBtnByXpath = "//a[text()='Contact']";
	String submitBtnByXpath = "//a[text()='Submit']";
	String msgByXpath = "(//strong[text()='We welcome your feedback']//..)[1]";
	String foreNameById = "forename";
	String emailById = "email";
	String messageById = "message";
	String successfulSubmissionByXpath = "//strong[contains(text(),'Thanks')]";
	String foreName;

	public boolean launchingBrowser() {
		boolean flag = false;
		try {
			confChrome();
			loadUrl("https://jupiter.cloud.planittesting.com/#/");
			windowMaximize();
			wait(10);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean ClickContactBtn() {
		boolean flag = false;
		try {
			WebElement contactBtn = locateByXpath(contactBtnByXpath);
			click(contactBtn);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;

	}

	public boolean ClickSubmitBtn() {
		boolean flag = false;
		try {
			WebElement submitBtn = locateByXpath(submitBtnByXpath);
			click(submitBtn);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean validateErrorMsg() {
		boolean flag = false;
		try {
			WebElement errorMsgTxt = locateByXpath(msgByXpath);
			String errorTxt = getText(errorMsgTxt);
			String assertTxt = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
			flag = errorTxt.equals(assertTxt);
			reportLog(flag, "error Msg displayed", "error msg not displayed");
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean validateMsg() {
		boolean flag = false;
		try {
			WebElement msgTxt = locateByXpath(msgByXpath);
			String msgActTxt = getText(msgTxt);
			String msgExpTxt = "We welcome your feedback - tell it how it is.";
			flag = msgExpTxt.equals(msgActTxt);
			reportLog(flag, "No errors displayed", "error msg displayed");
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean populateMandatoryFields() {
		boolean flag = false;
		try {
			flag = enterForeName();
			flag = enterEmailId();
			flag = enterMessage();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;

	}

	public boolean inputValidation(String expected, String actual) {
		boolean flag = false;
		try {
		if(expected.equals(actual)) {
			flag = true;
//			reportLog(flag, expected+" has been entered successfully", expected+" not entered");
		}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
			
	}
	public boolean enterForeName() {
		boolean flag = false;
		try {
			foreName = "new";
			WebElement locateById = locateById(foreNameById);
			sendKeys(locateById, foreName);
			String actual = getAttribute(locateById);
			flag = inputValidation(foreName, actual);
			reportLog(flag, "ForeName has been entered successfully", "Failed to enter ForeName");
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean enterEmailId() {
		boolean flag = false;
		try {
			String inputValue = "abc@123.com";
			WebElement email = locateById(emailById);
			sendKeys(email, inputValue);
			String actual = getAttribute(email);
			flag = inputValidation(inputValue, actual);
			reportLog(flag, "Email has been entered successfully", "Failed to enter Email");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean enterMessage() {
		boolean flag = false;
		try {
			WebElement msg = locateById(messageById);
			String inputValue = "Hello!!";
			sendKeys(msg, inputValue);
			String actual = getAttribute(msg);
			flag = inputValidation(inputValue, actual);
			reportLog(flag, "Message has been entered successfully", "Failed to enter Message");

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	public boolean validateSuccessfulSubmission() {
		boolean flag = false;
		try {
			//need to add explicit wait
		WebElement msg = locateByXpath(successfulSubmissionByXpath);
		String actualMsg = getText(msg);
		String expectedMsg = "Thanks "+foreName;
		flag = inputValidation(actualMsg, expectedMsg);
		reportLog(flag, "Succesfully Submitted", "Failed to Submit");
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
		
	}

}
