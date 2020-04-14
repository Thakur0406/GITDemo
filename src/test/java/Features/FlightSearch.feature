Feature: Flight Search Operation

Scenario Outline: User Search for return flight
Given The Browser is initialised
When User is navigated to "https://www.makemytrip.com/"
And User selects round trip option for searching flights
And User search from <FromCity> to <ToCity>
And User selects departure date <DepartureDate> and return date <ReturnDate>
And User selects adultcount <AdultCount>, childcount <ChildCount>, infantcount <InfantCount>  and class <Class>
And User clicks on serach button
Then Search result page is displayed

Examples:
|FromCity      |ToCity       |DepartureDate |ReturnDate |AdultCount |ChildCount |InfantCount	|Class            |
|Pune, India   |Delhi, India |10June20      |13June20   |2          |1          |0            |Business |
