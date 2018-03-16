package wsu.library_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.util.ArrayList;


public class GridViewActivity extends AppCompatActivity implements AsyncResponse {
    private static final String TAG = GridViewActivity.class.getSimpleName();
    private GridView mGridView;
    private ProgressBar mProgressBar;
    private GridViewAdapter mGridAdapter;
    private ArrayList<GridItem> mGridData;
    private SearchView searchView;

    int maxFlag=1;
    private String[] itemTitleString;
    private String[] itemTitleURL;
    private String[] itemAuthor;
    private String[] itemYear;
    private String[] itemAvailability;
    private String[] itemImage[];
    BufferedReader reader=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGridView = (GridView) findViewById(R.id.gridView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mGridData = new ArrayList<>();
        mGridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, mGridData);
        mGridView.setAdapter(mGridAdapter);
        searchView = (SearchView) findViewById(R.id.searchView);


        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                /*
                //Get item at position
                GridItem item = (GridItem) parent.getItemAtPosition(position);
                //Pass the image title and url to DetailsActivity
                Intent intent = new Intent(GridViewActivity.this, DetailsActivity.class);
                intent.putExtra("title", item.getBookTitle());
                intent.putExtra("url", item.getBookURL());
                startActivity(intent);
                */
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getData(query);
                mProgressBar.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return false;
        }
    });
    }

    private void getData(String query){
        DocumentListFetcher documentListFetcher = new DocumentListFetcher(this,query);
        documentListFetcher.delegate = this;
        documentListFetcher.execute("");
    }

    @Override
    public void processFinish(Document document){

        Elements resultListCellBlocks = document.getElementsByClass("resultListCellBlock");
        GridItem gridItem;
        mGridData.clear();

        for(Element resultListCellBlock : resultListCellBlocks){
            Element line1LinkContent = resultListCellBlock.select("div.line1Link").first();
            Element line2LinkContent = resultListCellBlock.select("div.line2Link").first();
            Element line3LinkContent = resultListCellBlock.select("div.line3Link").first();
            Element line4LinkContent = resultListCellBlock.select("div.line4Link").first();
            Element line5LinkContent = resultListCellBlock.select("div.line5Link").first();

            Element title = line1LinkContent.select("a").first();

            gridItem = new GridItem();
            gridItem.setBookTitle(title.text());
            gridItem.setBookURL(title.absUrl("href"));
            gridItem.setBookAuthor(line2LinkContent.text());
            gridItem.setBookYear(line3LinkContent.text());

            if(line4LinkContent.text().contains("multiple holdings available")){
                gridItem.setBookAvailability(" ");
            }
            else if(line4LinkContent.text().contains("no")){
                    gridItem.setBookAvailability("NO");
            }
            else if(line5LinkContent.text().contains("available")){
                gridItem.setBookAvailability("YES");
            }
            else{
                gridItem.setBookAvailability("NO");
            }

            mGridData.add(gridItem);
            mGridAdapter.setGridData(mGridData);
            mProgressBar.setVisibility(View.GONE);
        }

    }

    private void getNextPageData(String pageToken){

    }


}
