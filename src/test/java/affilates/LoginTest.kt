package affilates

import affilates.login.AffilateHttpManager
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
open class LoginTest {
    @Autowired
    private lateinit var affilateHttpManager : AffilateHttpManager

    @Test
    fun loginTest() {
        val result = affilateHttpManager.getPage()

        val response = result.returnResponse()
        Assert.assertTrue(response.statusLine.statusCode == 200)

        val output = ByteArrayOutputStream()
        response.entity.writeTo(output)
        val content = output.toString(Charset.defaultCharset().name())

        Assert.assertTrue(!content.isEmpty())
        Assert.assertTrue(content.contains("Affiliate Program - Home"))
    }
}