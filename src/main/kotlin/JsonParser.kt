import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonParser {
    private val gsonParser = Gson()
    //Como a blibioteca Gson exige uma classe para fazer o parser e minha saída era muito complexa, temos que utilizar o TypeToken
    private val typeToken = object : TypeToken<List<Map<String, String>>>() {}.type

    fun parser(json: String): List<Map<String, String>> {
        return gsonParser.fromJson(json, typeToken)
    }
}