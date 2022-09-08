package PageObjects.Jupiter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import PageObjects.Functions.ControlFunctions;

public class ShopPage extends ControlFunctions{

	String buyStuffedFrog = "//div[@class='products ng-scope']//descendant::a[2]";
	String buyStuffedFrogAmount = "//div[@class='products ng-scope']//descendant::span[2]";
	String buyFluffyBunny = "//div[@class='products ng-scope']//descendant::a[4]";
	String buyFluffyBunnyAmount = "//div[@class='products ng-scope']//descendant::span[4]";
	String fluffyBunnySubtotal = "//td[contains(text(),'Stuffed Frog')]//following::td[1]";
	String buyValentineBear ="//div[@class='products ng-scope']//descendant::a[7]";
	String buyValentineBearAmount ="//div[@class='products ng-scope']//descendant::span[7]";
	String valentineBearSubtotal = "//td[contains(text(),'Stuffed Frog')]//following::td[1]";
	String cartXpath = "//a[@href='#/cart']";
	String startShoppingBtn ="//a[text()='Start Shopping »']";
	List<String> amount = new ArrayList<String>();
	Map<String, Float> values = new HashMap<String, Float>();
	String productName;
	String productSubtotal = "//td[contains(text(),'"+productName+"')]//following::td[1]";



	
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
	
	public boolean clickStartShopping() {
		boolean flag=false;
		try {
			WebElement startShopping = locateByXpath(startShoppingBtn);
			click(startShopping);
			wait(10);
			flag=true;
		} catch (Exception e) {

			e.printStackTrace();
			flag=false;
		}
		return flag;

	}	


	public boolean buyStuffedFrog() {
		boolean flag= false;
		try {
			WebElement stuffedFrog= locateByXpath(buyStuffedFrog);
			for(int i=1;i<=2;i++) {
				click(stuffedFrog);
				List<String> value = getValue(buyStuffedFrogAmount);
				float totalAmount = totalAmount(value);
				values.put("StuffedFrog", totalAmount);
				flag=true;
			}} catch (Exception e) {

				e.printStackTrace();
				flag=false;
			}
		return flag;	

	}
	public boolean buyFluffyBunny() {
		boolean flag=false;
		try {
			WebElement fluffyBunny = locateByXpath(buyFluffyBunny);
			for(int i=1;i<=5;i++) {
				click(fluffyBunny);
				List<String> value=getValue(buyFluffyBunnyAmount);
				float totalAmount = totalAmount(value);
				values.put("FluffyBunny", totalAmount);
				
				flag=true;
			}} catch (Exception e) {

				e.printStackTrace();
				flag=false;
			}
		return flag;
	}

	public boolean buyValentineBear() {
		boolean flag=false;
		try {
			WebElement valentineBear = locateByXpath(buyValentineBear);
			for(int i=1;i<=3;i++) {
				click(valentineBear);
				List<String>value =getValue(buyValentineBearAmount);
				float totalAmount = totalAmount(value);
				values.put("ValentineBear", totalAmount);
				flag=true;
			}} catch (Exception e) {

				e.printStackTrace();
				flag=false;
			}
		return flag;
	}
	
	public List<String> getValue(String xpath) {
		List<String> listValues = new ArrayList<String>();
		WebElement value = locateByXpath(xpath);
		String price = value.getText();
		listValues.add(price);
		amount.add(price);
		return listValues;
	}
	
	public float totalAmount(List<String> value) {
		float total =0;
		float f = 0;
		for (int i = 0; i < value.size(); i++) {
			f=0;
			String price = value.get(i);
			String temp = "";
			for (int j = 0; j < price.length(); j++) {
			char c = price.charAt(j);
			if (c != '$') {
				temp = temp + c;
			}
			}
			f = Float.parseFloat(temp);
			total = total + f;
		}
		 return total;
	}

	public boolean clickCart() {
		boolean flag=false;
		try {
			WebElement cart = locateByXpath(cartXpath);
			click(cart);
			flag=true;
		} catch (Exception e) {

			e.printStackTrace();
			flag=false;
		}
		return flag;

	}	
	public float SubTotal(String product) {
		productName = product;
		WebElement sub = locateByXpath(productSubtotal);
		String text = sub.getText();
		List<String> value = new ArrayList<String>();
		value.add(text);
		float totalAmount = totalAmount(value);
		return totalAmount;
		
	}
	public boolean productSubTotalVerify() {
		boolean flag = false;
		List<String> li = new ArrayList<String>();
		li.add("StuffedFrog");
		li.add("FluffyBunny");
		li.add("ValentineBear");
		for (int i = 0; i < li.size(); i++) {
			float valentineBear = SubTotal(li.get(i));
			flag = Float.compare(valentineBear, values.get(li.get(i)))==0;
			reportLog(false,li.get(i)+" subtotal matched" , li.get(i)+" subtotal not matching");
		}
		return flag;
		
	}
}


