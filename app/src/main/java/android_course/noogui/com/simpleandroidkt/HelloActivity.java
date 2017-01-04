package android_course.noogui.com.simpleandroidkt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HeIios on 1/4/2017.
 */

public class HelloActivity extends AppCompatActivity {

    @BindView(R.id.txt_hello)
    TextView sayHi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloactivity);

        //dont forget to attach Butterknife library
        ButterKnife.bind(this);

        sayHi.setText("Wassup?");

        if(getIntent().hasExtra("name") ){
            String intentValue = getIntent().getExtras().getString("name");
            String message = "Wassup " + intentValue + "?";
            sayHi.setText(message);
        }
    }


}
