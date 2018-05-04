package affilates

import affilates.login.AffilateProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
open class HomeController {
    @Autowired
    private lateinit var affilateProvider : AffilateProvider

    @RequestMapping(value = "/")
    @ResponseBody
    open fun home() : String
    {
        return affilateProvider.getPage()
                .returnContent().asString()
    }
}