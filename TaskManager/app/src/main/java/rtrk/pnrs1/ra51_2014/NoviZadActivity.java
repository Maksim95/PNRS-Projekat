package rtrk.pnrs1.ra51_2014;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NoviZadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novi_zad);

        final Button crveni = (Button)findViewById(R.id.crveni);
        final Button zuti = (Button)findViewById(R.id.zuti);
        final Button zeleni = (Button)findViewById(R.id.zeleni);
        Button dodaj = (Button)findViewById(R.id.dodaj);
        Button izlaz = (Button)findViewById(R.id.izlaz);
        final EditText opis = (EditText)findViewById(R.id.opis);
        final EditText ime = (EditText)findViewById(R.id.ime);
        final Intent mainActivityIntent = new Intent(this,MainActivity.class);


        crveni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zuti.setEnabled(false);
                zeleni.setEnabled(false);
            }
        });
        zuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crveni.setEnabled(false);
                zeleni.setEnabled(false);
            }
        });
        zeleni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crveni.setEnabled(false);
                zuti.setEnabled(false);
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ime.getText().toString().trim().length()==0 && opis.getText().toString().trim().length()==0) {
                    startActivity(mainActivityIntent);
                }else
                    Toast.makeText(NoviZadActivity.this,R.string.toast,Toast.LENGTH_SHORT).show();
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
