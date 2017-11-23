package sabel.com.bitcoinrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etEuro;
    private EditText etBitcoin;
    private Button btnBerechenen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEuro = findViewById(R.id.et_euro);
        etBitcoin = findViewById(R.id.et_bitcoin);
        btnBerechenen = findViewById(R.id.btn_umrechnen);

        btnBerechenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(etEuro.toString()) > 0) {

                    Double d = Double.parseDouble(etEuro.toString());
                    d *= 2;
                    etBitcoin.setText( d.toString());
                }
            }
        });



    }


}
