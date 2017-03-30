package rtrk.pnrs1.ra51_2014;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class NoviZadActivity extends AppCompatActivity {

   private boolean enableDodaj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novi_zad);

        final Button crveni = (Button) findViewById(R.id.crveni);
        final Button zuti = (Button) findViewById(R.id.zuti);
        final Button zeleni = (Button) findViewById(R.id.zeleni);
        Button dodaj = (Button) findViewById(R.id.dodaj);
        Button izlaz = (Button) findViewById(R.id.izlaz);
        final EditText opis = (EditText) findViewById(R.id.opis);
        final EditText ime = (EditText) findViewById(R.id.ime);
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker2);
        final Intent mainActivityIntent = new Intent(this, MainActivity.class);
        enableDodaj=false;
        datePicker.setMinDate(System.currentTimeMillis()-1000);



        crveni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NoviZadActivity.this,R.string.priority1,Toast.LENGTH_SHORT).show();
                zuti.setEnabled(true);
                zeleni.setEnabled(true);
                crveni.setEnabled(false);
                crveni.setBackgroundColor(getResources().getColor(R.color.zuti));
                zuti.setBackgroundColor(getResources().getColor(R.color.zuti));
                zeleni.setBackgroundColor(getResources().getColor(R.color.zeleni));
                crveni.setBackgroundColor(getResources().getColor(R.color.crvena));
                enableDodaj=true;

            }
        });
        zuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NoviZadActivity.this,R.string.priority2,Toast.LENGTH_SHORT).show();
                crveni.setEnabled(true);
                zeleni.setEnabled(true);
                zuti.setEnabled(false);

                crveni.setBackgroundColor(getResources().getColor(R.color.crveni));
                zeleni.setBackgroundColor(getResources().getColor(R.color.zeleni));
                zuti.setBackgroundColor(getResources().getColor(R.color.zuta));
                enableDodaj=true;
            }
        });
        zeleni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NoviZadActivity.this,R.string.priority3,Toast.LENGTH_SHORT).show();
                crveni.setEnabled(true);
                zuti.setEnabled(true);
                zeleni.setEnabled(false);

                zuti.setBackgroundColor(getResources().getColor(R.color.zuti));
                crveni.setBackgroundColor(getResources().getColor(R.color.crveni));
                zeleni.setBackgroundColor(getResources().getColor(R.color.zelena));
                enableDodaj=true;
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(ime.getText().toString().trim().length() == 0 || opis.getText().toString().trim().length() == 0 )&& enableDodaj) {
                    startActivity(mainActivityIntent);
                } else
                    Toast.makeText(NoviZadActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
            }
        });
        izlaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivityIntent);
            }
        });



    }

}
