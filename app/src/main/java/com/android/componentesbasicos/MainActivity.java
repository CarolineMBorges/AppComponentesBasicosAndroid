package com.android.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resultado;
    private CheckBox checkBoxBranco, checkBoxVerde, checkBoxVermelho;
    List<String> check = new ArrayList<String>();
    private RadioGroup radioGroupEstoque;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.editTextNomeProdutoId);
        resultado = findViewById(R.id.textResultadoId);
        checkBoxBranco = findViewById(R.id.checkBoxBrancoId);
        checkBoxVerde = findViewById(R.id.checkBoxVerdeId);
        checkBoxVermelho = findViewById(R.id.checkBoxVermelhoId);
        radioGroupEstoque = findViewById(R.id.radioGroupEstoqueId);

        verificaRadioButton();
    }

    public void verificaCheck(){

        check.clear();

        if ( checkBoxBranco.isChecked() ){
            check.add( checkBoxBranco.getText().toString() );
        }
        if ( checkBoxVerde.isChecked() ){
            check.add( checkBoxVerde.getText().toString() );
        }
        if ( checkBoxVermelho.isChecked() ){
            check.add( checkBoxVermelho.getText().toString() );
        }

        resultado.setText( check.toString());
    }

    public void verificaRadioButton(){

        radioGroupEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.radioButtonSimId){
                    resultado.setText("Sim");
                }else{
                    resultado.setText("Não");
                }
            }
        });

    }


    public void btEnviar(View view){

        verificaRadioButton();

        verificaCheck();

        // recuperar texto do EditText
        String nomeProduto = campoProduto.getText().toString();
        resultado.setText( nomeProduto );

    }
}
