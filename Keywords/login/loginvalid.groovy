package login

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword

class LoginTest {

	@Keyword
	def loginJoAcademy(String email, String encryptedPassword) {
		WebUI.openBrowser('https://www.joacademy.com/login')

		WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/button by email'))

		WebUI.sendKeys(findTestObject('Object Repository/login/Page_- joacademy.com/input__email'), email)

		WebUI.sendKeys(findTestObject('Object Repository/login/Page_- joacademy.com/input__password'), '123456')

		WebUI.click(findTestObject('Object Repository/login/Page_- joacademy.com/join'))
	}
}
