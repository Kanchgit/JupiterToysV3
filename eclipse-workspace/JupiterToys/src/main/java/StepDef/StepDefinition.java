package StepDef;

import PageObjects.Functions.ControlFunctions;
import PageObjects.Jupiter.ContactPage;
import PageObjects.Jupiter.ShopPage;

public class StepDefinition extends ControlFunctions {

	public static void main(String[] args) {
		StepDefinition definition = new StepDefinition();
		definition.TC03();
	}

	public void TC01() {
		boolean flag = true;
		ContactPage contactPage = new ContactPage();
		if (flag)
			contactPage.launchingBrowser();
		if (flag)
			flag = contactPage.ClickContactBtn();
		if (flag)
			flag = contactPage.ClickSubmitBtn();
		if (flag)
			flag = contactPage.validateErrorMsg();
		if (flag)
			flag = contactPage.populateMandatoryFields();
		if (flag)
			flag = contactPage.validateMsg();
		if (flag)
			closeAllWindows();
	}

	public void TC02() {
		boolean flag = true;
		ContactPage contactPage = new ContactPage();
		if (flag)
			contactPage.launchingBrowser();
		if (flag)
			flag = contactPage.ClickContactBtn();
		if (flag)
			flag = contactPage.populateMandatoryFields();
		if (flag)
			flag = contactPage.ClickSubmitBtn();
		if (flag)
			flag = contactPage.validateSuccessfulSubmission();
		if (flag)
			closeAllWindows();
	}

	public void TC03() {
		boolean flag = true;
		ShopPage shopPage = new ShopPage();
		if (flag)
			flag = shopPage.launchingBrowser();
		if (flag)
			flag = shopPage.clickStartShopping();
		if (flag)
			flag = shopPage.buyFluffyBunny();
		if (flag)
			flag = shopPage.buyStuffedFrog();
		if (flag)
			flag = shopPage.buyValentineBear();
		if (flag)
			flag = shopPage.clickCart();

	}

}
