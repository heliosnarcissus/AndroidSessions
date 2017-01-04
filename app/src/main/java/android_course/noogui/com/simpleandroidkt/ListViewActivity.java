package android_course.noogui.com.simpleandroidkt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HeIios on 1/4/2017.
 */

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listview_list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ButterKnife.bind(this);

        listView.setAdapter(new ListAdapter(20));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position,
                            long l) {
        Toast.makeText(ListViewActivity.this, "Item Clicked " + (position + 1), Toast
                .LENGTH_SHORT).show();

    }

}
