package Config.General;

import Config.SeleniumConfig.AbstractPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Viral on 11/26/2016.
 */
public class Methods extends AbstractPage {


    protected static Wait<WebDriver> wait;

    /**
     * Initialize UserAbstractPage.
     *
     * @param driver .
     */
    public Methods(WebDriver driver) {
        super(driver);
    }

    /**
     * Open URL.
     * <p>
     * Open Entered URL Web Page.
     */
    public void openURL() {
        String URL = PropertiesConfig.getValue("URL");
        driver.get(URL);
    }

    /**
     * Get Current Page URL.
     *
     * @return Return Current Page URL in String.
     */
    //
    public String getCurrentURL() {
        String CurrentURL = driver.getCurrentUrl();

        return CurrentURL;
    }

    /**
     * Get Current Page Source.
     *
     * @return Return Current Page Source In String.
     */
    public String getPageSource() {
        String PageSource = driver.getPageSource();

        return PageSource;
    }

    /**
     * Web Page refresh.
     */
    public void refresh() {
        driver.navigate().refresh();
    }

    /**
     * Go To Previous Page.
     */
    public void goToPreviuosPage() {
        driver.navigate().back();
    }


    /**
     * Find Web Element By Class_Name.
     *
     * @param ClassName
     * @return Return Web Element.
     */
    public WebElement findByClassName(String ClassName) {
        WebElement element = driver.findElement(By.className(ClassName));

        return element;
    }

    /**
     * Find WebElement By CssSelector.
     *
     * @param CssSelector
     * @return Return Web Element.
     */
    public WebElement findByCssSelector(String CssSelector) {
        WebElement element = driver.findElement(By.cssSelector(CssSelector));

        return element;
    }

    /**
     * ram ID
     * <p>
     * Find Web Element By ID.
     *
     * @paturn Return Web Element.
     */
    public WebElement findById(String ID) {
        WebElement element = driver.findElement(By.id(ID));

        return element;
    }

    /**
     * Find Web Element By findByLinkText.
     *
     * @param linkText
     * @return Return Web Element.
     */
    public WebElement findByLinkText(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));

        return element;
    }

    /**
     * Find Web Element By Name.
     *
     * @param Name
     * @return Return Web Element.
     */
    public WebElement findByName(String Name) {
        WebElement element = driver.findElement(By.name(Name));

        return element;
    }

    /**
     * Find Web Element By Partial_Link_Text.
     *
     * @param PartialLinkText
     * @return Return Web Element.
     */
    public WebElement findByPartialLinkText(String PartialLinkText) {
        WebElement element = driver.findElement(By.partialLinkText(PartialLinkText));

        return element;
    }

    /**
     * Find Web Element By Tag_Name.
     *
     * @param TagName
     * @return Return Web Element.
     */
    public WebElement findByTagName(String TagName) {
        WebElement element = driver.findElement(By.tagName(TagName));

        return element;
    }

    /**
     * Find Web Element By findByXpath.
     *
     * @param XpathExpression
     * @return Return Web Element.
     */
    public WebElement findByXpath(String XpathExpression) {
        WebElement element = driver.findElement(By.xpath(XpathExpression));

        return element;
    }


    public boolean elementIsDisplayed(WebElement Element) {
        boolean Value = Element.isDisplayed();

        return Value;
    }

    public boolean elementIsSelected(WebElement Element) {
        boolean Value = Element.isSelected();

        return Value;
    }

    /**
     * Get Element currently Enabled or not.
     *
     * @param Element Enter Web Element.
     * @return Return Boolean Value (True Or False).
     */
    public boolean elementIsEnabled(WebElement Element) {
        boolean Value = Element.isEnabled();

        return Value;
    }


    /**
     * Wait Script.
     *
     * @param secs Enter Sec Value.
     *             Pause Or Sleep Script For Entered Sec.
     */
    public void pause(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException interruptedException) {

        }
    }

    /**
     * Highlight Element.
     *
     * @param Element Highlight Element With Solid Yellow Border.
     */
    //Highlight Element.
    public void highlightElement(WebElement Element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", Element);
        pause(2);
    }


    /**
     * Perform Alert Accept Operation.
     * <p>
     * Accept Or Ok Alert.
     */
    public void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Perform Alert Dismiss Operation.
     * <p>
     * Close Or Cancel Alert.
     */
    //
    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Get Alert Text.
     *
     * @return Return Alert Text.
     */
    //
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        return AlertText;
    }

    /**
     * Send Text On Alert.
     *
     * @param Text Type Text On Alert.
     */
    public void sendTextOnAlert(String Text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(Text);
    }

    /**
     * Open Mailinator Inbox.
     *
     * @param EmailAddress Enter Mailinator Email Address.
     *                     Redirect On Entered Email Address Inbox Page.
     */
    public void openMailinatorInbox(String EmailAddress) {
        pause(2);
        String emailParsed[] = EmailAddress.split("@");
        String url = "https://www.mailinator.com/inbox2.jsp?public_to=" + emailParsed[0] + "#/#public_maildirdiv";
        driver.get(url);
    }

    /**
     * Get Current Date And Time.
     *
     * @return Return Current Date & Time.
     */
    public String getCurrentDateTime() {
        Date date = new Date();

        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-YYYY|HH:mm:ss:SS");
        TimeZone timeZone = TimeZone.getDefault();
        Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
        sd.setCalendar(cal);
        return sd.format(date);
    }

    /**
     * Generate Random Numeric Number.
     *
     * @param Length Enter String Length In Integer.
     * @return Return Random Numeric String.
     */
    public String generateRandomNumber(int Length) {

        String RandomNumber = RandomStringUtils.randomNumeric(Length);
        return RandomNumber;

    }

    /**
     * Generate Random AlphaNumeric String.
     *
     * @param Length Enter String Length In Integer.
     * @return Return Random AlphaNumeric String.
     */
    public String generateRandomAlphanumeric(int Length) {
        String RandomName = RandomStringUtils.randomAlphanumeric(Length);
        return RandomName;
    }


    /**
     * Generate Random AlphaBetic String.
     *
     * @param Length Enter String Length In Integer.
     * @return Return Random Alphabetic String.
     **/
    public String generateRandomAlphabetic(int Length) {
        String RandomName = RandomStringUtils.randomAlphabetic(Length);
        return RandomName;
    }

    /**
     * Generate Random AlphaAscii String.
     *
     * @param Length Enter String Length In Integer.
     * @return Return Random Ascii String.
     */
    public String generateRandomAscii(int Length) {
        String RandomAscii = RandomStringUtils.randomAscii(Length);
        return RandomAscii;
    }


    public void log(String msg) {

        Reporter.log(msg);
        System.out.println(msg);
    }


    public List<WebElement> findListOfElementsByXpath(String Xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(Xpath));
        return elements;
        //WebElement element = elements.get(1);
        //element.click();
    }

    /**
     * List Of Web Elements Find By Name.
     *
     * @param Name Enter Name In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByName(String Name) {
        List<WebElement> elements = driver.findElements(By.name(Name));
        return elements;
    }

    /**
     * List Of Web Elements Find By Id.
     *
     * @param Id Enter Id In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsById(String Id) {
        List<WebElement> elements = driver.findElements(By.id(Id));
        return elements;
    }

    /**
     * List Of Web Elements Find By Class Name.
     *
     * @param ClassName Enter Class Name In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByClassName(String ClassName) {
        List<WebElement> elements = driver.findElements(By.className(ClassName));
        return elements;
    }

    /**
     * List Of Web Elements Find By Css Selector.
     *
     * @param CssSelector Enter Css Selector In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByCssSelector(String CssSelector) {
        List<WebElement> elements = driver.findElements(By.cssSelector(CssSelector));
        return elements;
    }

    /**
     * List Of Web Elements Find By Link Text.
     *
     * @param LinkText Enter Link Text In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByLinkText(String LinkText) {
        List<WebElement> elements = driver.findElements(By.linkText(LinkText));
        return elements;
    }

    /**
     * List Of Web Elements Find By Partial Link Text.
     *
     * @param PartialLinkText Enter Partial Link Text In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByPartialLinkText(String PartialLinkText) {
        List<WebElement> elements = driver.findElements(By.partialLinkText(PartialLinkText));
        return elements;
    }

    /**
     * List Of Web Elements Find By Tag Name.
     *
     * @param TagName Enter Tag Name In String.
     * @return Return List Of Web Elements.
     */
    public List<WebElement> findListOfElementsByTagName(String TagName) {
        List<WebElement> elements = driver.findElements(By.tagName(TagName));
        return elements;
    }


//----------------------------------------------------------------------------------------------------


    public Properties loadPropertyFile(String propertyFile) {

        Properties prop = new Properties();
        InputStream input = null;


        try {

            File file = new File("src\\resources\\ObjectRepo\\" + propertyFile + ".properties");

            input = new FileInputStream(file.getAbsoluteFile());

            // load a properties file
            prop.load(input);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }


    public Map<String, String> loadProperty(String fileName, String propertyName) {

        Map<String, String> elementProperty = new HashMap<String, String>();

        String elementType = "";
        String elementLocator = "";
        Properties elementProp = loadPropertyFile(fileName);

        if (elementProp.getProperty(propertyName + ".xpath") != null) {

            elementType = "xpath";
            elementLocator = elementProp.getProperty(propertyName + ".xpath");
        }


        if (elementProp.getProperty(propertyName + ".id") != null) {

            elementType = "id";
            elementLocator = elementProp.getProperty(propertyName + ".id");
        }


        if (elementProp.getProperty(propertyName + ".className") != null) {

            elementType = "className";
            elementLocator = elementProp.getProperty(propertyName + ".className");
        }


        if (elementProp.getProperty(propertyName + ".tagName") != null) {

            elementType = "tagName";
            elementLocator = elementProp.getProperty(propertyName + ".tagName");
        }


        if (elementProp.getProperty(propertyName + ".name") != null) {

            elementType = "name";
            elementLocator = elementProp.getProperty(propertyName + ".name");
        }


        if (elementProp.getProperty(propertyName + ".linkText") != null) {

            elementType = "linkText";
            elementLocator = elementProp.getProperty(propertyName + ".linkText");
        }


        if (elementProp.getProperty(propertyName + ".partialLinkText") != null) {

            elementType = "partialLinkText";
            elementLocator = elementProp.getProperty(propertyName + ".partialLinkText");
        }


        if (elementProp.getProperty(propertyName + ".cssSelector") != null) {

            elementType = "cssSelector";
            elementLocator = elementProp.getProperty(propertyName + ".cssSelector");
        }


        System.out.println(elementType);
        System.out.println(elementLocator);

        elementProperty.put("elementType", elementType);
        elementProperty.put("elementLocator", elementLocator);


        return elementProperty;
    }


    public void waitForElement(String fileName, String propertyName) {
        wait = new WebDriverWait(driver, 600);
        try {


            Map<String, String> elementProperty = loadProperty(fileName, propertyName);

            WebElement element = null;

            if (elementProperty.get("elementType").equals("xpath")) {
                wait.until(visibilityOfElementLocated(By.xpath(elementProperty.get("elementLocator"))));
            }

            if (elementProperty.get("elementType").equals("id")) {
                wait.until(visibilityOfElementLocated(By.id(elementProperty.get("elementLocator"))));


            }

            if (elementProperty.get("elementType").equals("className")) {
                wait.until(visibilityOfElementLocated(By.className(elementProperty.get("elementLocator"))));
            }

            if (elementProperty.get("elementType").equals("tagName")) {
                wait.until(visibilityOfElementLocated(By.tagName(elementProperty.get("elementLocator"))));
            }


            if (elementProperty.get("elementType").equals("linkText")) {
                wait.until(visibilityOfElementLocated(By.linkText(elementProperty.get("elementLocator"))));
            }


            if (elementProperty.get("elementType").equals("partialLinkText")) {
                wait.until(visibilityOfElementLocated(By.partialLinkText(elementProperty.get("elementLocator"))));
            }


            if (elementProperty.get("elementType").equals("name")) {
                wait.until(visibilityOfElementLocated(By.name(elementProperty.get("elementLocator"))));
            }

            if (elementProperty.get("elementType").equals("cssSelector")) {
                wait.until(visibilityOfElementLocated(By.cssSelector(elementProperty.get("elementLocator"))));
            }

        } catch (Exception e) {
        }
    }


    public WebElement findElement(String fileName, String propertyName) {

        Map<String, String> elementProperty = loadProperty(fileName, propertyName);

        WebElement element = null;

        if (elementProperty.get("elementType").equals("xpath")) {
            element = findByXpath(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("id")) {
            element = findById(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("className")) {
            element = findByClassName(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("tagName")) {
            element = findByTagName(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("linkText")) {
            element = findByLinkText(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("partialLinkText")) {
            element = findByPartialLinkText(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("name")) {
            element = findByPartialLinkText(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("cssSelector")) {
            element = findByPartialLinkText(elementProperty.get("elementLocator"));
        }

        return element;
    }


    public List<WebElement> findElementList(String fileName, String propertyName) {

        Map<String, String> elementProperty = loadProperty(fileName, propertyName);

        List<WebElement> elementList = null;

        if (elementProperty.get("elementType").equals("xpath")) {
            elementList = findListOfElementsByXpath(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("id")) {
            elementList = findListOfElementsById(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("className")) {
            elementList = findListOfElementsByClassName(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("tagName")) {
            elementList = findListOfElementsByTagName(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("linkText")) {
            elementList = findListOfElementsByLinkText(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("partialLinkText")) {
            elementList = findListOfElementsByPartialLinkText(elementProperty.get("elementLocator"));
        }


        if (elementProperty.get("elementType").equals("name")) {
            elementList = findListOfElementsByName(elementProperty.get("elementLocator"));
        }

        if (elementProperty.get("elementType").equals("cssSelector")) {
            elementList = findListOfElementsByCssSelector(elementProperty.get("elementLocator"));
        }

        return elementList;
    }


















}