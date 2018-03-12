package wsu.library_application;

/**
 * Created by Josil on 1/15/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<GridItem> {
    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();
    public GridViewAdapter(Context mContext, int layoutResourceId, ArrayList<GridItem> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
    }
    /**
     * Updates grid data and refresh grid items.
     * @param mGridData
     */
    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;
        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            //holder.titleTextView = (TextView) row.findViewById(R.id.grid_item_title);
            holder.bookTypeImageView = (ImageView) row.findViewById(R.id.itemTypeImage);
            holder.bookTitleTextView = (TextView) row.findViewById(R.id.itemTitleText);
            holder.bookAuthorTextView = (TextView) row.findViewById(R.id.itemAuthorText);
            holder.bookYearTextView = (TextView) row.findViewById(R.id.itemYearText);
            holder.bookAvailabilityImageView = (ImageView) row.findViewById(R.id.itemAvailabilityImage);
            holder.bookAvailability = (TextView) row.findViewById(R.id.itemAvailabilityText);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        GridItem item = mGridData.get(position);
        holder.bookTypeImageView.setBackgroundResource(R.drawable.book_icon);
        holder.bookTitleTextView.setText(item.getBookTitle());
        holder.bookAuthorTextView.setText(item.getBookAuthor());
        holder.bookYearTextView.setText(item.getBookYear());
        if(item.getBookAvailability().equalsIgnoreCase("yes")){
            holder.bookAvailability.setText("Book available in Library");
            holder.bookAvailabilityImageView.setBackgroundResource(R.drawable.tickmark);
        }
        else{
            holder.bookAvailability.setText("Book Not available in Library");
            holder.bookAvailabilityImageView.setBackgroundResource(R.drawable.crossmark);
        }

        return row;
    }
    static class ViewHolder {
        TextView bookTitleTextView;
        TextView bookYearTextView;
        TextView bookAuthorTextView;
        TextView bookAvailability;
        ImageView bookTypeImageView;
        ImageView bookAvailabilityImageView;
    }
}
