import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import login.LoginTest as LoginTest
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

import internal.GlobalVariable as GlobalVariable

LoginTest login = new LoginTest()

login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'), 10)

WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

WebUI.sendKeys(findTestObject('Object Repository/verify the search field exam/Page_- joacademy.com/input name file'), 'سورة البلد الآيات الكريمة (1-10)')

boolean cart_exam =WebUI.verifyElementVisible(findTestObject('verify the search field exam/Page_- joacademy.com/verify exma cart'))

if(cart_exam ) {
	WebUI.comment("passed")
	
}else {
	WebUI.comment("field")
}
WebUI.closeBrowser()

