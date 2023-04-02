import java.io.File
import java.util.Properties

private val propFile = File("local.properties").inputStream()

object PropertiesReader {
    private val properties = Properties()

    init {
        properties.load(propFile)
    }

    fun getProperty(key: String):String = properties.getProperty(key)
}