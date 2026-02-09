package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CalenderDateUtility {

    private static void selectDate(WebDriver driver, String day, String month, String year, String labelText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            By calendarIcon = By.xpath("//label[normalize-space(text())='" + labelText + "']/ancestor::div[contains(@class,'igx-input-group__bundle')][1]//igx-icon[@title='Choose Date']");
            By calendarPopup = By.xpath("//div[contains(@class,'igx-calendar-picker__dates')]");
            By monthTitle = By.xpath("(//span[contains(@class,'igx-calendar-picker__date')])[1]");
            By yearTitle = By.xpath("(//span[contains(@class,'igx-calendar-picker__date')])[2]");
            By prevButton = By.xpath("//igx-icon[normalize-space(text())='keyboard_arrow_left']");
            By nextButton = By.xpath("//igx-icon[normalize-space(text())='keyboard_arrow_right']");
            By dayItems = By.xpath("//span[contains(@class,'igx-calendar__date-content')]");

            wait.until(ExpectedConditions.elementToBeClickable(calendarIcon)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

            int targetMonth = getMonthNumber(month);
            int targetYear = Integer.parseInt(year);

            int maxTries = 25;
            while (maxTries-- > 0) {
                try {
                	wait.until(ExpectedConditions.visibilityOfElementLocated(calendarPopup));

                    String currentMonthText = driver.findElement(monthTitle).getText().trim();
                    String currentYearText = driver.findElement(yearTitle).getText().trim();

                    System.out.println("Displayed Month: " + currentMonthText);
                    System.out.println("Displayed Year : " + currentYearText);

                    int currentMonth = getMonthNumber(currentMonthText);
                    int currentYear = Integer.parseInt(currentYearText);

                    if (currentMonth == targetMonth && currentYear == targetYear) {
                        // ✅ Directly select the date here
                        List<WebElement> allDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dayItems));
                        for (WebElement d : allDates) {
                            if (d.getText().equals(day)) {
                                d.click();
                                return; // success
                            }
                        }
                        throw new RuntimeException("Date '" + day + "' not found in displayed calendar");
                    }

                    // Navigation
                    if (currentYear < targetYear || (currentYear == targetYear && currentMonth < targetMonth)) {
                        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
                        next.click();
                    } else {
                        WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(prevButton));
                        prev.click();
                    }

                    Thread.sleep(200);

                } catch (Exception ex) {
                    System.out.println("⚠️ Calendar popup vanished. Reopening...");
                    driver.findElement(calendarIcon).click();
                    Thread.sleep(300); // Give UI time to settle
                }
            }
            throw new RuntimeException("Could not reach target month/year: " + month + " " + year);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Date selection failed for label '" + labelText + "'", e);
        }
    }

    private static int getMonthNumber(String monthName) {
        monthName = monthName.trim().toLowerCase();

        switch (monthName) {
            case "jan":
            case "january":
                return 1;
            case "feb":
            case "february":
                return 2;
            case "mar":
            case "march":
                return 3;
            case "apr":
            case "april":
                return 4;
            case "may":
                return 5;
            case "jun":
            case "june":
                return 6;
            case "jul":
            case "july":
                return 7;
            case "aug":
            case "august":
                return 8;
            case "sep":
            case "sept":
            case "september":
                return 9;
            case "oct":
            case "october":
                return 10;
            case "nov":
            case "november":
                return 11;
            case "dec":
            case "december":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month: " + monthName);
        }
    }
}
