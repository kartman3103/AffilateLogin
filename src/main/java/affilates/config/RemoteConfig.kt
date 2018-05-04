package affilates.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ConfigurationProperties
@PropertySource("classpath:config/remote.yml")
open class RemoteConfig {
    var url : String = ""

    var login : String = ""

    var password : String = ""

    var cookieHeaderName : String = ""
}