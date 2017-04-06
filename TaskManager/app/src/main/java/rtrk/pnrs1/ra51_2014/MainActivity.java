package rtrk.pnrs1.ra51_2014;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent statIntent = new Intent(this,Main2Activity.class);
        final Intent nzIntent = new Intent(this,NoviZadActivity.class);
        Button nz = (Button) findViewById(R.id.button);
        Button stat = (Button) findViewById(R.id.button2);
        ListView lv = (ListView)findViewById(R.id.list);
        lv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                nzIntent.putExtra(R.string.Osvezi,R.string.Osvezi);
                nzIntent.putExtra(R.string.Obrisi,R.string.Obrisi);
                startActivity(nzIntent);
                return false;
            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(statIntent);
            }
        });
        nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(nzIntent);
            }
        });

    }
}
