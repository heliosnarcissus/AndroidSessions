package android_course.noogui.com.simpleandroidkt;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeIios on 1/4/2017.
 */

public class ListAdapter extends BaseAdapter {

    private static final String TAG = ListAdapter.class.getName();

    private List<SampleNewObject> stringList;

    public ListAdapter(int max) {
        stringList = new ArrayList<SampleNewObject>();
        for (int i = 0; i < max; i++) {
            SampleNewObject object = new SampleNewObject();
            object.setItemNumber("Item # " + (i + 1));
            if (i % 2 == 0) {
                object.setEnabled(true);
            } else {
                object.setEnabled(false);
            }
            stringList.add(object);
        }
    }


    class SampleNewObject {
        public String getItemNumber() {
            return itemNumber;
        }

        public void setItemNumber(String itemNumber) {
            this.itemNumber = itemNumber;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        private String itemNumber;
        private boolean enabled = false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_row, viewGroup, false);

            holder = new ViewHolder();
            holder.header = (TextView) view.findViewById(R.id.row_header);
            holder.item = (TextView) view.findViewById(R.id.row_item);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

//        if (stringList.get(position).isEnabled()) {
//            holder.header.setEnabled(true);
//            holder.header.setTextColor(ContextCompat.getColor(viewGroup
//                    .getContext(), android.R.color.black));
//        } else {
//            holder.header.setEnabled(false);
//            holder.header.setTextColor(ContextCompat.getColor(viewGroup
//                    .getContext(), android.R.color.holo_red_dark));
//            holder.header.setAlpha(0.5f);
//        }

        holder.header.setText(String.valueOf(position + 1));
        holder.item.setText(stringList.get(position).getItemNumber());

        return view;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public SampleNewObject getItem(int index) {
        return stringList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //optimization using ViewHolde which is later gives birth to RecyclerView in Android Lollipop/Android 5.0
    private static class ViewHolder {
        TextView header;
        TextView item;
    }

}
