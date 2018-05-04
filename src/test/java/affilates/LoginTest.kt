package affilates

import affilates.login.LoginManager
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
open class LoginTest {
    @Autowired
    private lateinit var loginManager : LoginManager

    @Test
    fun testLogin() {
        val response = loginManager.login()
        Assert.assertNotNull(response)
        Assert.assertEquals(200, response.statusLine.statusCode)
    }
}