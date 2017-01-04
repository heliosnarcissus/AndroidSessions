package android_course.noogui.com.simpleandroidkt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    //bind the widgets to butterknife outside onCreate
    @BindView(R.id.bt_linear)
    Button bt_linear;

    @BindView(R.id.bt_relative)
    Button bt_relative;

    @BindView(R.id.bt_intent)
    Button bt_intent;

    @BindView(R.id.bt_listviewdemo)
    Button bt_listview;

    Intent changeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //set touch listeners for buttons
        bt_linear.setOnClickListener(this);
        bt_relative.setOnClickListener(this);
        bt_intent.setOnClickListener(this);
        bt_listview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.bt_linear:
                changeActivity = new Intent(this, LinearLayoutActivity.class );
                startActivity(changeActivity);//dont forget to start activity
                break;

            case  R.id.bt_relative:
                changeActivity = new Intent(MainActivity.this, RelativeLayoutActivity.class );
                startActivity(changeActivity);//dont forget to start activity
                break;

            case R.id.bt_intent:
                changeActivity = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(changeActivity);//dont forget to start activity
                break;

            case R.id.bt_listviewdemo:
                changeActivity = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(changeActivity);//dont forget to start activity
                break;
            }


    }

}


