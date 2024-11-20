import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import login.LoginTest as LoginTest
import com.kms.katalon.core.model.FailureHandling as FailureHandling

LoginTest login = new LoginTest()
login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')

WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'), 10)
WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/Field semester'))
WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/select semester 1'))

if (WebUI.verifyElementVisible(findTestObject('Filter in exam/Page_- joacademy.com/Field semester'), FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.comment("Passed: الفصل تم اختياره بنجاح")
} else {
    WebUI.comment("Failed: لم يتم العثور على حقل الفصل")
	WebUI.closeBrowser()
}

WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/field class'))
WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/class one'))

if (WebUI.verifyElementVisible(findTestObject('Filter in exam/Page_- joacademy.com/field class'), FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.comment("Passed: الصف تم اختياره بنجاح")
} else {
    WebUI.comment("Failed: لم يتم العثور على حقل الصف")
	WebUI.closeBrowser()
}

WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/field material'))
WebUI.click(findTestObject('Filter in exam/Page_- joacademy.com/select material'))

if (WebUI.verifyElementVisible(findTestObject('Filter in exam/Page_- joacademy.com/field material'), FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.comment("Passed: المادة تم اختيارها بنجاح")
} else {
    WebUI.comment("Failed: لم يتم العثور على حقل المادة")
}

if (WebUI.verifyElementVisible(findTestObject('Filter in exam/Page_- joacademy.com/verify cart esma'), FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.comment("Found: تم العثور على زر create exam. سيتم إغلاق المتصفح.")
    WebUI.closeBrowser()
} else {
    WebUI.comment("لم يتم العثور على create exam.")
}

WebUI.closeBrowser()
