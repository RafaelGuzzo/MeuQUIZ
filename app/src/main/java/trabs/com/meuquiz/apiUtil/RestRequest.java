package trabs.com.meuquiz.apiUtil;

import java.net.URL;

public class RestRequest {
    private String urlTest = "https://jsonplaceholder.typicode.com/todos/1";
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void sendGet() throws Exception{

        URL url = new URL(urlTest);
        MyAsyncTask request = new MyAsyncTask();

        this.resultado = (String) request.execute(url).get();
    }
}
