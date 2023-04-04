import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IMDBContentExtractor() : ContentExtractor {
    //override val contentList: MutableList<Content> = mutableListOf()
    override fun extractContentList(json: String): List<Content> {

        val jsonItems = JsonParser.parser(json)

        //Desafio da Aula 3, usar Streams
        return jsonItems.map { item ->
            Content(
                title = item["title"]!!,
                imageUrl = item["url"]!!
            )
        }.toList()
        /*for (item in jsonItems) {
            val content = Content(
                title = item.get("title")!!,
                imageUrl = item.get("image")!!
            )
            contentList.add(content)
        }

        return contentList*/
    }
}