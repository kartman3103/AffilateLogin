package affilates.format

import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
open class ResponseFormatter {
    fun formatMainPage(html : String) : String {
        return Jsoup.parse(html)
                .getElementById("index-overview-table")
                .html()
    }
}