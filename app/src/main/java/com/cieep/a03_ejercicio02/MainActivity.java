package com.cieep.a03_ejercicio02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cieep.a03_ejercicio02.modelos.BiciModel;
import com.cieep.a03_ejercicio02.modelos.CocheModel;
import com.cieep.a03_ejercicio02.modelos.MotoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Atributos para Vista
    private TextView lblCantidadCoches;
    private TextView lblCantidadMotos;
    private TextView lblCantidadBicis;
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;
    // Atributos para Lógica
    private ArrayList<CocheModel> listaCoches;
    private ArrayList<MotoModel> listaMotos;
    private ArrayList<BiciModel> listaBicis;
    // Atributos para Eventos
    private ActivityResultLauncher<Intent> crearCocheLauncher;
    private ActivityResultLauncher<Intent> crearMotoLauncher;
    private ActivityResultLauncher<Intent> crearBiciLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaVariables();

        inicializarLaunchers();

        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearCocheLauncher.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });
    }

    private void inicializarLaunchers() {
        crearCocheLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                CocheModel coche = (CocheModel) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null) {
                                    listaCoches.add(coche);
                                    lblCantidadCoches.setText("Coches: "+listaCoches.size());
                                }

                            }
                            else {
                                Toast.makeText(MainActivity.this, "NO ESTAN LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        crearBiciLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                BiciModel bici = (BiciModel) result.getData().getExtras().getSerializable("BICI");
                                if (bici != null) {
                                    listaBicis.add(bici);
                                    lblCantidadBicis.setText("Bicis: "+listaBicis.size());
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "NO ESTAN LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        crearMotoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                MotoModel moto = (MotoModel) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null) {
                                    listaMotos.add(moto);
                                    lblCantidadMotos.setText("Motos: "+listaMotos.size());
                                }

                            }
                            else {
                                Toast.makeText(MainActivity.this, "NO ESTAN LOS DATOS", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void inicializaVariables() {
        lblCantidadCoches = findViewById(R.id.lblCantidadCochesMain);
        lblCantidadMotos = findViewById(R.id.lblCantidadMotosMain);
        lblCantidadBicis = findViewById(R.id.lblCantidadBicisMain);
        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBiciMain);

        listaBicis = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaCoches = new ArrayList<>();
    }
}