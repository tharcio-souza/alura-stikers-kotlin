import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IMDBContentExtractor() : ContentExtractor {
    override val contentList: MutableList<Content> = mutableListOf()

    override fun extractContentList(json: String): List<Content> {
        val parserGson = Gson()
        //Como a blibioteca Gson exige uma classe para fazer o parser e minha saída era muito complexa, temos que utilizar o TypeToken
        val typeToken = object : TypeToken<List<Map<String, String>>>() {}.type
        val jsonItems: List<Map<String,String>> = parserGson.fromJson(json,typeToken)

        for (item in jsonItems) {
            val content = Content(
                title = item.get("title")!!,
                imageUrl = item.get("image")!!
            )
            contentList.add(content)
        }

        return contentList
    }
}