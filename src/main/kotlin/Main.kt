import java.net.URL

fun main(args: Array<String>) {
    val apiKey = PropertiesReader

    //Criando a conexão e baixando o JSON
    //val url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"
    //val url = "http://localhost:8080/linguagens"
    //val contentExtractor = IMDBContentExtractor()

    val url = "https://api.nasa.gov/planetary/apod?api_key=${apiKey.getProperty("nasaApiKey")}&start_date=2022-06-12&end_date=2022-06-14"
    val contentExtractor = NasaContentExtractor()

    val apiConnection = ApiConnection()
    val json = apiConnection.takeJson(url)

    val contentList = contentExtractor.extractContentList(json)

    //Criar Figurinhas
    val generator = StikerGenerator()

    for (content in contentList) {
        val inputFile = URL(content.imageUrl).openStream()
        generator.create(inputFile, content.title)
    }
}