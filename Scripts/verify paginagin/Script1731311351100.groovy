import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import login.LoginTest as LoginTest
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

LoginTest login = new LoginTest()
login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/navegate to the E-exam page/Page_- joacademy.com/button e exams'))

TestObject button1 = findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 1')
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()

js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", WebUI.findWebElement(button1))

WebUI.waitForElementClickable(button1, 30)

js.executeScript("arguments[0].click();", WebUI.findWebElement(button1))

WebUI.delay(6)

TestObject button4 = findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 4')

js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", WebUI.findWebElement(button4))

WebUI.waitForElementClickable(button4, 30)

js.executeScript("arguments[0].click();", WebUI.findWebElement(button4))

WebUI.delay(6)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
