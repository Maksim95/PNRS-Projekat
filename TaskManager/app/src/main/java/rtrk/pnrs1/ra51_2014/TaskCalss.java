package rtrk.pnrs1.ra51_2014;

import android.widget.DatePicker;
import android.widget.TimePicker;

import java.io.Serializable;

/**
 * Created by student on 6.4.2017.
 */

public class TaskCalss implements Serializable {
    public enum priority{LOW,MID,HIGH};
    private String ime;
    private  String opis;
    private DatePicker datum;
    private TimePicker vreme;
    private priority proritet;

    public TaskCalss(String ime, priority proritet, TimePicker vreme, DatePicker datum, String opis) {
        this.ime = ime;
        this.proritet = proritet;
        this.vreme = vreme;
        this.datum = datum;
        this.opis = opis;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setProritet(priority proritet) {
        this.proritet = proritet;
    }

    public void setVreme(TimePicker vreme) {
        this.vreme = vreme;
    }

    public void setDatum(DatePicker datum) {
        this.datum = datum;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getIme() {
        return ime;
    }

    public String getOpis() {
        return opis;
    }

    public DatePicker getDatum() {
        return datum;
    }

    public TimePicker getVreme() {
        return vreme;
    }

    public priority getProritet() {
        return proritet;
    }
}
