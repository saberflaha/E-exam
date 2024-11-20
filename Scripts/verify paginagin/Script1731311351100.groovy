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

LoginTest login = new LoginTest()
login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/navegate to the E-exam page/Page_- joacademy.com/button e exams'))


WebUI.scrollToElement(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 1'), 30)
WebUI.waitForElementClickable(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 1'), 30)
WebUI.click(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 1'))
WebUI.delay(6)

WebUI.scrollToElement(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 4'), 30)
WebUI.waitForElementClickable(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 4'), 30)
WebUI.click(findTestObject('Object Repository/P-Exma/Page_- joacademy.com/button 4'))
WebUI.delay(6)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
