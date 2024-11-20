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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import java.util.Random

def runTestCase1() {
	WebUI.openBrowser('https://www.joacademy.com/online-exams')
	WebUI.maximizeWindow()
	WebUI.waitForElementVisible(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'), 10)
	WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

	List<WebElement> startExamButtons = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/submet exam/Page_- joacademy.com/start exma'), 10)
	if (startExamButtons != null && !startExamButtons.isEmpty()) {
		Random random = new Random()
		int randomIndex = random.nextInt(startExamButtons.size())
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(startExamButtons.get(randomIndex)))
	} else {
		WebUI.comment('No start exam buttons found!')
		return
	}

	boolean isShouldLoginVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/message login or create acount/Page_- joacademy.com/plase login'), FailureHandling.CONTINUE_ON_FAILURE)
	boolean isLoginVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/message login or create acount/Page_- joacademy.com/create acount'), FailureHandling.CONTINUE_ON_FAILURE)
	boolean isCreateAccountVisible = WebUI.verifyElementVisible(findTestObject('Object Repository/message login or create acount/Page_- joacademy.com/login'), FailureHandling.CONTINUE_ON_FAILURE)
	
	if (isShouldLoginVisible && isLoginVisible && isCreateAccountVisible) {
		WebUI.comment('تم التحقق من جميع العناصر بنجاح، سيتم الانتقال إلى runTestCase2.')
	   
		WebUI.closeBrowser()
		
		
	} else {
		WebUI.comment('أحد العناصر أو أكثر غير مرئي، لن يتم تشغيل runTestCase2.')
	}
}

def executeTestCases() {
	runTestCase1()
}

executeTestCases()