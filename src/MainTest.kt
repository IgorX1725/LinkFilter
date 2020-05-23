import org.json.JSONObject
import okhttp3.*
import java.io.IOException

//Arquivo Criado para testar as Requisições
//Ao executa-la, será possível visualizar no console todos os Links Encontrados no JSON
    fun main() {
        var url = "https://api.imgur.com/3/gallery/search/?q=cats"
        var authorization = "Client-ID 1ceddedc03a5d71"

        var client = OkHttpClient()
        var request = OkHttpRequest(client)

        request.GET(url,authorization, object : Callback {
            override fun onResponse(call: Call?, response: Response) {
                val responseData = response.body()?.string()
                val jsonArray = JSONObject(responseData)

                var catLinks = GetLinks.get(jsonArray)
                catLinks.forEach({
                    println(it)
                  })
           }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Request Failure.")
            }
        })

    }


