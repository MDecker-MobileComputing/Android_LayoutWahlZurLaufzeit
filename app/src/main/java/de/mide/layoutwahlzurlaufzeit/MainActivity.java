package de.mide.layoutwahlzurlaufzeit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Einstiegs-Activity einer Android-App, die demonstriert, dass man
 * die zu landende Layout-Datei erst zur Laufzeit bestimmen kann.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity
                          implements View.OnClickListener {

    /**
     * Key für Extra in Intent-Objekt vom Typ CHAR, für Ablage
     * der Kennung der Layout-Datei.
     */
    public static final String EXTRA_KEY_LAYOUT = "EXTRA_KEY_LAYOUT_KENNUNG";


    /** Button zum Laden von <i>layout_a</i>. */
    protected Button _buttonA = null;

    /** Button zum Laden von <i>layout_b</i>. */
    protected Button _buttonB = null;


    /**
     * Lifecycle-Methode: Lädt Layout-Datei, holt Java-Objekte
     * für die beiden Buttons und setzt die Activity-Instanz
     * selbst als Event-Handler-Objekt für die beiden Buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _buttonA = findViewById(R.id.button_a);
        _buttonA.setOnClickListener(this);

        _buttonB = findViewById(R.id.button_b);
        _buttonB.setOnClickListener(this);
    }


    /**
     * Event-Handler-Methode für die beiden Buttons.
     *
     * @param view Button, der Event ausgelöst hat.
     */
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, ActivityZwei.class);

        if (view == _buttonA) {

            intent.putExtra(EXTRA_KEY_LAYOUT, 'a');

        } else if (view == _buttonB) {

            intent.putExtra(EXTRA_KEY_LAYOUT, 'b');

        } else {

            Toast.makeText(
                    this,
                    "Interner Fehler: Unerwarteter Button hat Event ausgelöst",
                    Toast.LENGTH_LONG).show();
            return;
        }


        startActivity(intent);
    }

}
