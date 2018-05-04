package affilates.login

import affilates.config.RemoteConfig
import org.apache.http.HttpResponse
import org.apache.http.auth.AuthScope
import org.apache.http.auth.UsernamePasswordCredentials
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.BasicCredentialsProvider
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class LoginManager {
    @Autowired
    private lateinit var remoteConfig : RemoteConfig

    fun login() : HttpResponse {
        val credentialsProvider = BasicCredentialsProvider()
        val credentials = UsernamePasswordCredentials(
                remoteConfig.login, remoteConfig.password)

        credentialsProvider.setCredentials(AuthScope.ANY, credentials)

        val httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build()

        return httpClient.execute(HttpPost(remoteConfig.url))
    }
}