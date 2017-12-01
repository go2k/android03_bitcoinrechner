package sabel.com.bitcoinrechner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEuro;
    private EditText etBitcoin;
    private Button btnBerechenen;
    private Button btnBeenden;
    private double kursEuroBitcoin = 8919.13;

    private boolean bETText = false;
    private boolean bETBitcoin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEuro = findViewById(R.id.et_euro);
        etBitcoin = findViewById(R.id.et_bitcoin);
        btnBerechenen = findViewById(R.id.btn_umrechnen);
        btnBeenden = findViewById(R.id.btn_beenden);

        btnBerechenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etEuro.getText().toString().length() > 0) {
                    double euro = Double.parseDouble(etEuro.getText().toString());
                    double ergebnis = euroInBitCoin(euro);
                    etBitcoin.setText(String.valueOf(ergebnis));
                } else {
                    double bitcoin = Double.parseDouble(etBitcoin.getText().toString());
                    double ergebnis = bitCoinInEuro(bitcoin);
                    etEuro.setText(String.valueOf(ergebnis));
                }

            }
        });

        btnBeenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        etEuro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!bETText) {
                    try {
                        bETBitcoin = true;
                        double euro = Double.parseDouble(charSequence.toString());
                        double ergebnis = euroInBitCoin(euro);
                        etBitcoin.setText(String.valueOf(ergebnis));
                        bETBitcoin = false;
                    } catch (NumberFormatException e) {
                        etBitcoin.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etBitcoin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!bETBitcoin) {
                    try {
                        bETText = true;
                        double bitcoin = Double.parseDouble(charSequence.toString());
                        double ergebnis = bitCoinInEuro(bitcoin);
                        etEuro.setText(String.valueOf(ergebnis));
                        bETText = false;
                    } catch (NumberFormatException e) {
                        etEuro.setText("");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    /**
     * Rechnet Euro in Bitcoin um
     *
     * @param betragInEuro
     * @return betragInBitcoin
     */
    private double euroInBitCoin(double betragInEuro) {
        return betragInEuro / kursEuroBitcoin;
    }

    /**
     * Rechnet Bitcoin in Euro um
     *
     * @param betragInEuro
     * @return betragInBitCoin
     */
    private double bitCoinInEuro(double betragInEuro) {
        return betragInEuro * kursEuroBitcoin;
    }

}
