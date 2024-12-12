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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

def runTestCase3() {
    // ⏩ تسجيل الدخول
    LoginTest login = new LoginTest()
    login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')
    
    // ⏩ تكبير نافذة المتصفح
    WebUI.maximizeWindow()
    
    // ⏩ الانتقال إلى صفحة الاختبارات الإلكترونية
    WebUI.waitForElementVisible(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'), 10)
    WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

    // 🔍 البحث عن أزرار "بدء الامتحان"
    List<WebElement> startExamButtons = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/submet exam/Page_- joacademy.com/start exma'), 10)
    
    if (startExamButtons != null && !startExamButtons.isEmpty()) {
        Random random = new Random()
        int randomIndex = random.nextInt(startExamButtons.size())
        
        // 🟢 النقر على زر عشوائي "بدء الامتحان"
        WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(startExamButtons.get(randomIndex)))
        WebUI.comment('✅ تم النقر على زر بدء الامتحان.')
    } else {
        WebUI.comment('❌ لم يتم العثور على أزرار بدء الامتحان!')
        return
    }

    // ⏸️ الانتظار قليلاً قبل التبديل إلى نافذة الامتحان
    WebUI.delay(5)
    
    // ⏩ التبديل إلى نافذة الاختبار (index 1)
    WebUI.switchToWindowIndex(1)

    // 🔍 البحث عن جميع الإجابات (أزرار radio) باستخدام الـ CSS المحدد
    TestObject answerOption = new TestObject('AnswerOption')
    answerOption.addProperty('css', ConditionType.EQUALS, 'button[role="radio"][type="button"]')

    List<WebElement> answerButtons = WebUiCommonHelper.findWebElements(answerOption, 10)

    if (answerButtons != null && !answerButtons.isEmpty()) {
        int numOfAnswers = answerButtons.size()
        WebUI.comment("عدد الخيارات المتاحة: " + numOfAnswers)

        for (int i = 0; i < numOfAnswers; i++) {
            WebElement answerButton = answerButtons.get(i)
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
            
            // 🟢 التمرير إلى الزر باستخدام scrollIntoView
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", answerButton)
            
            // 🟢 النقر على الزر باستخدام JavaScript Click
            js.executeScript("arguments[0].click();", answerButton)
            WebUI.comment("✅ تم اختيار الإجابة رقم: " + (i + 1))
        }
    } else {
        WebUI.comment('❌ لم يتم العثور على أي إجابات باستخدام button[role="radio"][type="button"]')
    }

    // 🟢 التمرير إلى زر "إنهاء الامتحان" والنقر عليه
    TestObject finishExamButton = findTestObject('Object Repository/submet exam/Page_- joacademy.com/finsh exma')
    JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", WebUI.findWebElement(finishExamButton))
    WebUI.waitForElementClickable(finishExamButton, 30)
    js.executeScript("arguments[0].click();", WebUI.findWebElement(finishExamButton))
    WebUI.comment('✅ تم النقر على زر إنهاء الامتحان.')

    // ⏸️ الانتظار قليلاً قبل التحقق من النتيجة
    WebUI.delay(5)

    // 🔍 التحقق من عناصر "النتيجة"
    WebUI.verifyElementVisible(findTestObject('Object Repository/submet exam/Page_(1-10) - joacademy.com/exam review'))


    // ⛔️ إغلاق المتصفح
    WebUI.closeBrowser()
}

def executeTestCases() {
    runTestCase3()
}

executeTestCases()
