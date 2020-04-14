package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMT_HomePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
		
	public MMT_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
		
	}

	@FindBy(css = "li[data-cy='roundTrip']")WebElement roundTripButton;
	@FindBy(css = "label[for='fromCity']")WebElement fromCity;
	@FindBy(css = "input[placeholder='From']")WebElement fromCityTextBox;
	@FindBy(css = "div[id='react-autowhatever-1'] div ul li")List<WebElement> fromSelection;
	@FindBy(css = "label[for='toCity']")WebElement toCity;
	@FindBy(css = "input[placeholder='To']")WebElement toCityTextBox;
	@FindBy(css = "label[for='toCity']+div div[id='react-autowhatever-1'] div ul li")List<WebElement> toSelection;
	
	
	//@FindBy(css = "li[id='react-autowhatever-1-section-0-item-0'] div p")WebElement suggestiveText;
	//@FindBy(css = "label[for='toCity']+div li[id='react-autowhatever-1-section-0-item-0'] div+div")WebElement toSuggestiveText;
	//@FindBy(css = "label[for='toCity']+div li[role='option']")List<WebElement> toSuggestiveList;
	
	@FindBy(css = "label[for='departure']")WebElement departure;
	@FindBy(css = "div[class='DayPicker-Caption'] div")WebElement firstMonthBox;
	@FindBy(css = "div[class='DayPicker-Month'] + div div div")WebElement secondMonthBox;
	@FindBy(css = "span[class='DayPicker-NavButton DayPicker-NavButton--next']")WebElement nextMonthNavigation;
	@FindBy(css = "div[class='DayPicker-Day']")List<WebElement> firstMonthDate;
	@FindBy(css = "div[class='DayPicker-Month'] + div div[class='DayPicker-Day']")List<WebElement> secondMonthDate;
	
	@FindBy(css = "label[for='travellers']")WebElement travellers;
	@FindBy(css = "div[class='appendBottom20'] ul li[data-cy^='adults']")List<WebElement> adultCount;
	@FindBy(css = "div[class='appendBottom20'] ul li[data-cy^='children']")List<WebElement> childrenCount;	
	@FindBy(css = "div[class='appendBottom20'] ul li[data-cy^='infants']")List<WebElement> infantsCount;
	@FindBy(css = "div[class='appendBottom20'] ul li[data-cy^='travel']")List<WebElement> travelClass;
	@FindBy(css = "div[class='travellers'] button[type='button']")WebElement classApply;
	@FindBy(css = "a[class*='widgetSearchBtn']")WebElement searchButton;
	
	/*
	 * @FindBy(css = "div[class='appendBottom20'] div ul")List<WebElement>
	 * childrenCount;
	 * 
	 * @FindBy(css = "div[class='appendBottom20'] div+div ul")List<WebElement>
	 * infantsCount;
	 * 
	 * @FindBy(css = "div[class='appendBottom20'] ul+div+p+ul")List<WebElement>
	 * travelClass;
	 */
				
	public WebElement getRoundTripButton() {
		return roundTripButton;		
	}
	
	public WebElement getFromCity() {
		return fromCity;
	}
	
	public WebElement getFromCityTextBox() {
		return fromCityTextBox;
	}
	
	public List<WebElement> getFromSelection() {
		return fromSelection;
	}
	
	public WebElement getToCity() {
		return toCity;
	}
	
	public WebElement getToCityTextBox() {
		return toCityTextBox;
	}
	
	public List<WebElement> getToSelection() {
		return toSelection;
	}
	
	/*
	 * public WebElement getSuggestiveText() { return suggestiveText; }
	 * 
	 * public WebElement getToSuggestiveText() { return toSuggestiveText; }
	 * 
	 * public List<WebElement> getToSuggestiveList() { return toSuggestiveList; }
	 */
	
	public WebElement getDeparture() {
		return departure;
	}
	
	public WebElement getFirstMonthBox() {
		return firstMonthBox;
	}
	
	public WebElement getSecondMonthBox() {
		return secondMonthBox;
	}
	
	public WebElement getNextMonthNavigation() {
		return nextMonthNavigation;
	}
	
	public List<WebElement> getFirstMonthDate() {
		return firstMonthDate;
	}
	
	public List<WebElement> getSecondMonthDate(){
		return secondMonthDate;
	}
	
	public WebElement getTravellers(){
		return travellers;
	}
	
	public List<WebElement> getAdultCount(){
		return adultCount;
	}
	
	public List<WebElement> getChildrenCount(){
		return childrenCount;
	}
	
	public List<WebElement> getInfantCount(){
		return infantsCount;
	}
	
	public List<WebElement> getTravelClass(){
		return travelClass;
	}
	
	public WebElement getClassApply(){
		return classApply;
	}
	
	public WebElement getSearchButton(){
		return searchButton;
	}
}
