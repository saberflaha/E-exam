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
import login.LoginTest as LoginTest
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import java.util.Random

def runTestCase3() {
    LoginTest login = new LoginTest()
    login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')
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

    WebUI.delay(5)
    WebUI.switchToWindowIndex(1)

    TestObject questionsSelector = new TestObject('DynamicQuestions')
    questionsSelector.addProperty('css', ConditionType.EQUALS, 'div.tw-bg-white.tw-rounded-md')

    List<WebElement> questions = WebUiCommonHelper.findWebElements(questionsSelector, 10)

    if (questions != null && !questions.isEmpty()) {
        int numOfQuestions = questions.size()
        WebUI.comment("عدد الأسئلة الموجودة: " + numOfQuestions)

        for (int i = 0; i <= numOfQuestions; i++) {
            String cssSelector = "div.tw-bg-white.tw-rounded-md:nth-of-type(" + (i + 1) + ") [class='tw-mx-0 tw-my-2'] [type]"

            TestObject questionTestObject = new TestObject("DynamicObject" + i)
            questionTestObject.addProperty('css', ConditionType.EQUALS, cssSelector)

            if (WebUI.verifyElementPresent(questionTestObject, 10, FailureHandling.OPTIONAL)) {
                WebElement element = WebUiCommonHelper.findWebElement(questionTestObject, 10)
                WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
            } else {
                WebUI.comment("العنصر غير موجود للسؤال: " + (i + 1))
            }
        }
    } else {
        WebUI.comment('لا توجد أسئلة بالحدود المحددة: div.tw-bg-white.tw-rounded-md')
    }

    if (WebUI.verifyElementPresent(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 10, FailureHandling.OPTIONAL)) {
        WebUI.scrollToElement(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'), 0)
        WebUI.click(findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma'))
    } else {
        WebUI.comment('العنصر غير موجود: إنهاء الامتحان')
    }
	
		WebUI.verifyElementText(findTestObject('Object Repository/submet exam/Page_(1-10) - joacademy.com/exam review'), 'مراجة الأختبار')
		WebUI.verifyElementText(findTestObject('Object Repository/submet exam/Page_(1-10) - joacademy.com/Correct Answers Number of Questions'),   'الإجابات الصحيحة/عدد الأسألة')
		WebUI.verifyElementVisible(findTestObject('Object Repository/submet exam/Page_(1-10) - joacademy.com/mark exma'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/submet exam/Page_(1-10) - joacademy.com/The result'))
	
       WebUI.closeBrowser()
}

def executeTestCases() {
    runTestCase3()
}

executeTestCases()
