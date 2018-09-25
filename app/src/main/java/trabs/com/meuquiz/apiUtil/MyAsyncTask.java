package trabs.com.meuquiz.apiUtil;

import android.os.AsyncTask;

import java.net.URL;

public class MyAsyncTask extends AsyncTask {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Object doInBackground(Object[] objects) {

        URL url = (URL) objects[0];
        String result = NetworkUtils.getJsonFromApi(url);
        return result;
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
    }
}
