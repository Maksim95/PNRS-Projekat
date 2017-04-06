package rtrk.pnrs1.ra51_2014;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class NoviZadActivity extends AppCompatActivity {

   private boolean enableDodaj;
   private enum priority {LOW,MID,HIGH};
    private int i=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novi_zad);
        final ListAdapter adapter = new ListAdapter(this);

        final priority[] prioritet = new priority[1];
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
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String delete = extras.getString(R.string.Obrisi);
            String update = extras.getString(R.string.Osvezi);
            dodaj.setText(update);
            izlaz.setText(delete);
        }


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
                i=2;

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
                i=1;
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
                i=0;
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(ime.getText().toString().trim().length() == 0 || opis.getText().toString().trim().length() == 0 )&& enableDodaj) {
                    TaskCalss task = new TaskCalss(ime.getText().toString().trim(),/*prioritet*/,timePicker,datePicker,opis.getText().toString().trim());
                    adapter.addTask(task);
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
