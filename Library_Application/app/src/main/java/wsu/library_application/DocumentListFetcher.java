package wsu.library_application;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Josil on 2/13/2018.
 */

public class DocumentListFetcher extends AsyncTask<String, Void, Document> {

    private static Context context = null;
    //private Elements contents = null;
    public AsyncResponse delegate = null;
    private String query;

    public DocumentListFetcher(Context context,String query){
        if(null == this.context){
            this.context = context;
        }
        this.query = query;
    }

    protected Document doInBackground(String... urls) {

        Elements contents = null;
        Document doc = null;
        try {
            if(query.contains(" ")){
                query = query.replace(" ","+");
            }
            doc = Jsoup.connect("http://libcat.wichita.edu/vwebv/search?searchArg="+query+"&searchCode=GKEY%5E*&setLimit=1&recCount=10&searchType=1").get();
        } catch (Exception e) {
            String r = e.toString();
        }
        return doc;
    }

    @Override
    protected void onPostExecute(Document document) {
        delegate.processFinish(document);
    }

}
