import okhttp3.*

//Classe Responsável por fazer a requisição à API para coletar o JSON
class OkHttpRequest(client: OkHttpClient) {

    internal var client = OkHttpClient()

    init {
        this.client = client
    }

    //Metodo responsável por criar o método HTTP GET para coletar o JSON
    //Este metodo retorna uma CallBack com a resposta da requisição GET
    fun GET(url: String, authorization : String, callback: Callback): Call {
        val request = Request.Builder()
                .url(url)
                .header("Authorization",authorization)
                .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    companion object {
        val JSON = MediaType.parse("application/json; charset=utf-8")
    }
}