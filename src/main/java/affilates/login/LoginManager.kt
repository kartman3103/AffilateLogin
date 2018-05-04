package affilates.login

import affilates.config.RemoteConfig
import org.apache.http.Header
import org.apache.http.NameValuePair
import org.apache.http.client.fluent.Form
import org.apache.http.client.fluent.Request
import org.apache.http.client.fluent.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class LoginManager {
    @Autowired
    private lateinit var remoteConfig : RemoteConfig

    fun login() : Response {
        val cookies = Request.Post(remoteConfig.url).execute()
                .returnResponse()
                .getHeaders(remoteConfig.cookieHeaderName)

        loginWithFormData(cookies)
        return loginInternal(cookies)
    }

    private fun loginWithFormData(cookies : Array<Header>) : Response {
        return Request.Post(remoteConfig.url)
                .setHeaders(*cookies)
                .bodyForm(getFormData())
                .execute()
    }

    private fun loginInternal(cookies : Array<Header>) : Response {
        return Request.Get(remoteConfig.url)
                .setHeaders(*cookies)
                .execute()
    }

    private fun getFormData() : List<NameValuePair> {
        return Form.form()
                .add("username", remoteConfig.login)
                .add("password", remoteConfig.password)
                .build()
    }
}