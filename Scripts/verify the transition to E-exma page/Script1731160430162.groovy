import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import login.LoginTest as LoginTest

LoginTest login = new LoginTest()
login.loginJoAcademy('saber22@gmail.com', 'RigbBhfdqOBGNlJIWM1ClA==')
WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'), 10)
WebUI.click(findTestObject('navegate to the E-exam page/Page_- joacademy.com/button e exams'))

boolean isTitleCorrect = WebUI.verifyElementText(findTestObject('navegate to the E-exam page/Page_- joacademy.com/verify title page'), 'الامتحانات الإلكترونية', FailureHandling.CONTINUE_ON_FAILURE)
boolean isSubtitleCorrect = WebUI.verifyElementText(findTestObject('navegate to the E-exam page/Page_- joacademy.com/verify subtitle'), 'هنا يمكنك تصفح جميع الامتحانات الإلكترونية للإستفادة من امتحانات جو أكاديمي', FailureHandling.CONTINUE_ON_FAILURE)

if (isTitleCorrect && isSubtitleCorrect) {
    WebUI.comment("تم التحقق بنجاح: العنوان والنص الفرعي متطابقان.")
    WebUI.closeBrowser()
} else {
    WebUI.comment("التحقق من النصوص فشل.")
    WebUI.closeBrowser()
}
