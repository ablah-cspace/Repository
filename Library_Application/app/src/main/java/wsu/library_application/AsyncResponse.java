package wsu.library_application;

import org.jsoup.nodes.Document;

/**
 * Created by Josil on 2/13/2018.
 */

public interface AsyncResponse {
    public void processFinish(Document output);
}
