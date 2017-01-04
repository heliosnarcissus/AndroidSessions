package android_course.noogui.com.simpleandroidkt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HeIios on 1/4/2017.
 */

public class IntentActivity extends AppCompatActivity {

    @BindView(R.id.bt_sayhello)
    Button bt_sayHello;

    @BindView(R.id.txt_name)
    EditText txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        //Dont foget to bind Butterknife library on onCreate
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_sayhello)
    protected  void sayHello(){
        Intent intent = new Intent(IntentActivity.this, HelloActivity.class);
        //key value pair
        intent.putExtra("name", txt_name.getText().toString());
        startActivity(intent);
    }


}
