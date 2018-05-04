package affilates

import affilates.format.ResponseFormatter
import affilates.login.AffilateProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
open class HomeController {
    @Autowired
    private lateinit var affilateProvider : AffilateProvider

    @Autowired
    private lateinit var responseFormatter : ResponseFormatter

    @RequestMapping(value = "/")
    @ResponseBody
    open fun home() : String
    {
        val response = affilateProvider.getPage().returnContent()
        return responseFormatter.formatMainPage(response.asString())
    }
}