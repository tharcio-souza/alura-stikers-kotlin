import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class ApiConnection {

    fun takeJson(url: String): String {
        val address = URI.create(url)
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder(address).GET().build()
        val response = client.send(request,HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}