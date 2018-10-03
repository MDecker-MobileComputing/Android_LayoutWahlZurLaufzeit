package de.mide.layoutwahlzurlaufzeit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Sekundäre Activity, bestimmt zu ladende Layout-Datei erst zur Laufzeit.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class ActivityZwei extends Activity {


    /**
     * Lifecycle-Methode: Zu ladende Layout-Datei wird zur Laufzeit
     * anhand Extra in Intent-Objekt, mit dem diese Activity gestartet
     * wurde, bestimmt.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if ( intent.hasExtra(MainActivity.EXTRA_KEY_LAYOUT) == false ) {

            Toast.makeText(
                    this,
                    "Internet Fehler: Keine Layout-Kennung mitgegeben.",
                    Toast.LENGTH_LONG).show();

            finish();

        } else {

            char layoutKennung = intent.getCharExtra(MainActivity.EXTRA_KEY_LAYOUT, 'x');
            // "x" ist Default-Key falls kein Char mit dem angegebenen Schlüssel gefunden wurde

            switch (layoutKennung) {
                case 'a':
                    setContentView(R.layout.layout_a);
                    break;

                case 'b':
                    setContentView(R.layout.layout_b);
                    break;

                default:
                    Toast.makeText(
                            this,
                            "Internet Fehler: Ungültiges Layout angefordert.",
                            Toast.LENGTH_LONG).show();
                    finish();
            }

        }

    } // Ende Methode "onCreate()"

}
