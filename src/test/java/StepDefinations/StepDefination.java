package StepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.MMT_HomePage;
import Resources.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends Utilities {

	MMT_HomePage MMT_HomePage;

	@Given("^The Browser is initialised$")
	public void The_Browser_is_initialised() throws IOException {
		driver = InitialiseDriver();
	}

	@When("^User is navigated to \"([^\"]*)\"$")
	public void User_is_navigated_to_some_URL(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	@And("^User selects round trip option for searching flights$")
	public void User_selects_round_trip_option_for_searching_flights() {
		MMT_HomePage = new MMT_HomePage(driver);
		MMT_HomePage.getRoundTripButton().click();
	}

	@And("^User search from (.+) to (.+)$")
	public void User_search_from_FromCity_to_ToCity(String FromCity, String ToCity) throws InterruptedException {
		
		MMT_HomePage.getFromCity().click();
		MMT_HomePage.getFromCityTextBox().clear();
		MMT_HomePage.getFromCityTextBox().sendKeys(FromCity);
		Thread.sleep(10);
		int FromSelectionSize = MMT_HomePage.getFromSelection().size();
		for (int i = 0; i < FromSelectionSize; i++) {
			WebElement FromSelection = MMT_HomePage.getFromSelection().get(i);
			Thread.sleep(5);
			//String FromSelectionText1 = FromSelection.getText();
	    	String FromSelectionText = FromSelection.getText();
	    	String[] splitFromSelectionText = FromSelectionText.split("\n");
	    	String formatedFromSelectionText = splitFromSelectionText[0].trim();
	    	if(formatedFromSelectionText.equalsIgnoreCase(FromCity)) {
			  WebElement FromCityToCLick = MMT_HomePage.getFromSelection().get(i);
			  FromCityToCLick.click();
			  break;
			}
		}
		
		MMT_HomePage.getToCityTextBox().clear();
		MMT_HomePage.getToCityTextBox().sendKeys(ToCity);
        Thread.sleep(10);
		int ToSelectionSize = MMT_HomePage.getToSelection().size();
		for (int j = 0; j < ToSelectionSize; j++) {
			WebElement ToSelection = MMT_HomePage.getToSelection().get(j);
			Thread.sleep(5);
			//String ToSelectionText1 = ToSelection.getText();
			String ToSelectionText = ToSelection.getText();
	    	String[] splitToSelectionText = ToSelectionText.split("\n");
	    	String formatedToSelectionText = splitToSelectionText[0].trim();
	    	if(formatedToSelectionText.equalsIgnoreCase(ToCity)) {
	    		Thread.sleep(5);
	    	  WebElement ToCityToCLick = MMT_HomePage.getToSelection().get(j);
	    	  ToCityToCLick.click();
			  break;
			}
		}
	}
		
	@And("^User selects departure date (.+) and return date (.+)$")
	public void User_selects_departure_date_and_return_date(String departureDate, String returnDate) throws InterruptedException {
		String DepartureFirstMonthBox = MMT_HomePage.getFirstMonthBox().getText();
		String[] splitDepartureFirstMonthBox = DepartureFirstMonthBox.split("2");
		String FormatedDepartureMonth = splitDepartureFirstMonthBox[0].trim();
		if (departureDate.contains(FormatedDepartureMonth)) {
			int FirstMonthCount = MMT_HomePage.getFirstMonthDate().size();
			for (int m = 0; m < FirstMonthCount; m++) {
				String FirstMonthDateText = MMT_HomePage.getFirstMonthDate().get(m).getAttribute("aria-label");
				String[] splitFirstMonthDateText = FirstMonthDateText.split(" ");
				String FormattedFirstMonthDateText = splitFirstMonthDateText[2].trim();
				if (departureDate.contains(FormattedFirstMonthDateText)) {
					MMT_HomePage.getFirstMonthDate().get(m).click();
					int FirstMonthCountReturn = MMT_HomePage.getFirstMonthDate().size();
					for (int k = 0; k < FirstMonthCountReturn; k++) {
						String ReturnMonthDateText = MMT_HomePage.getFirstMonthDate().get(k).getAttribute("aria-label");
						String[] splitReturnMonthDateText = ReturnMonthDateText.split(" ");
						String FormattedReturnMonthDateText = splitReturnMonthDateText[2].trim();
						if (returnDate.startsWith(FormattedReturnMonthDateText)) {
							MMT_HomePage.getFirstMonthDate().get(k).click();
							break;
						}
					}
					break;
				}
			}
		} else {
			boolean flag = true;
			do {
				String DepartureSecondMonthBox = MMT_HomePage.getSecondMonthBox().getText();
				String[] splitDepartureSecondMonthBox = DepartureSecondMonthBox.split("2");
				String FormatedDepartureSecondMonth = splitDepartureSecondMonthBox[0].trim();
				if (departureDate.contains(FormatedDepartureSecondMonth)) {
					flag = false;
					int SecondMonthCount = MMT_HomePage.getSecondMonthDate().size();
					for (int n = 0; n < SecondMonthCount; n++) {
						String SecondMonthDateText = MMT_HomePage.getSecondMonthDate().get(n).getAttribute("aria-label");
						String[] splitSecondMonthDateText = SecondMonthDateText.split(" ");
						String FormattedSecondMonthDateText = splitSecondMonthDateText[2].trim();
						if (departureDate.contains(FormattedSecondMonthDateText)) {
							MMT_HomePage.getSecondMonthDate().get(n).click();
							//Thread.sleep(5);
							int SecondMonthCountReturn = MMT_HomePage.getSecondMonthDate().size();
							for (int l = 0; l < SecondMonthCountReturn; l++) {
								WebElement ReturnMonthDate1 = MMT_HomePage.getSecondMonthDate().get(l);
								WebElement ReturnMonthDate = MMT_HomePage.getSecondMonthDate().get(l);
								String ReturnMonthDateText = ReturnMonthDate.getAttribute("aria-label");
								String[] splitReturnMonthDateText = ReturnMonthDateText.split(" ");
								String FormattedReturnMonthDateText = splitReturnMonthDateText[2].trim();
								if (returnDate.startsWith(FormattedReturnMonthDateText)) {
									MMT_HomePage.getFirstMonthDate().get(l).click();
									break;
								}
							}
							break;
						}
					}

				} else {
					MMT_HomePage.getNextMonthNavigation().click();
				}
			} while (flag);
		}
	}
	
	@And("^User selects adultcount (.+), childcount (.+), infantcount (.+)  and class (.+)$")
	public void User_selects_adultcount_childcount_infantcount_and_class(int adultCount, int childCount, int infantCount, String travelClass) {
		MMT_HomePage.getTravellers().click();
		int AdultCountSize = MMT_HomePage.getAdultCount().size();
		for (int p = 0; p < AdultCountSize; p++) {
			String AdultCountText = MMT_HomePage.getAdultCount().get(p).getText();
			String [] SplitAdultCountText = AdultCountText.split("\n");
			String FormatedAdultCountText = SplitAdultCountText[0].trim();
			int AdultCountInt = Integer.parseInt(FormatedAdultCountText);
			if (adultCount == AdultCountInt) {
				MMT_HomePage.getAdultCount().get(p).click();
				break;
			}
		}
		
		int ChildrenCountSize = MMT_HomePage.getChildrenCount().size();
		for (int q = 0; q < ChildrenCountSize; q++) {
			String ChildCountText = MMT_HomePage.getChildrenCount().get(q).getText();
			String [] SplitChildCountText = ChildCountText.split("\n");
			String FormatedChildCountText = SplitChildCountText[0].trim();
			int ChildCountInt = Integer.parseInt(FormatedChildCountText);
			if (childCount==ChildCountInt) {
				MMT_HomePage.getChildrenCount().get(q).click();
				break;
			}
		}
		
		int InfantCountSize = MMT_HomePage.getInfantCount().size();
		for (int r = 0; r < InfantCountSize; r++) {
			String InfantCountText = MMT_HomePage.getInfantCount().get(r).getText();
			String [] SplitInfantCountText = InfantCountText.split("\n");
			String FormatedInfantCountText = SplitInfantCountText[0].trim();
			int InfantCountInt = Integer.parseInt(FormatedInfantCountText);
			if (infantCount==InfantCountInt) {
				MMT_HomePage.getInfantCount().get(r).click();
				break;
			}
		}
		
		int ClassCountSize = MMT_HomePage.getTravelClass().size();
		for (int s = 0; s < ClassCountSize; s++) {
			String ClassCountText = MMT_HomePage.getTravelClass().get(s).getText();
			if (travelClass.equalsIgnoreCase(ClassCountText)) {
				MMT_HomePage.getTravelClass().get(s).click();
				break;
			}
		}
		
		MMT_HomePage.getClassApply().click();
	}

	@And("^User clicks on serach button$")
	public void User_clicks_on_serach_button() {
		MMT_HomePage.getSearchButton().click();
	}

	@Then("^Search result page is displayed$")
	public void Search_result_page_is_displayed() {

	}

}
