package affilates

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application {
    companion object {
        @JvmStatic fun main(args : Array<String>) {
            SpringApplication.run(arrayOf(Application::class.java), args)
        }
    }
}