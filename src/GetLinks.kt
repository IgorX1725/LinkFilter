import org.json.JSONObject

//Classe responsável por filtrar o JSON e retornar somente a lista dos Links
class GetLinks {
    companion object {
        //Metodo estático responsável por "pegar" os links do JSON
        //OBS: Este método retorna um **ARRAYLIST** como resposta contendo todos os links encontrados
        fun get(jsonObject: JSONObject): ArrayList<String> {

            var catsLinks = ArrayList<String>()
            var jsonArray = jsonObject.getJSONArray("data")

            jsonArray.forEach({
                var imagesObject = JSONObject(it.toString())
                if(imagesObject.has("images")) {
                    var imagesArray = imagesObject.getJSONArray("images")
                    imagesArray.forEach({
                        if (JSONObject(it.toString()).get("type").toString().contains("image")) {
                            if(JSONObject(it.toString()).get("link").toString().isNotEmpty()) {
                                var link = JSONObject(it.toString()).get("link").toString()
                                catsLinks.add(link)
                            }
                        }
                    })
                }
            })
            return catsLinks
        }
    }
}