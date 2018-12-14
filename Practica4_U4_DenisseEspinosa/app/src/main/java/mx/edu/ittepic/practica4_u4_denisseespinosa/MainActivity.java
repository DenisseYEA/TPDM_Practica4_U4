package mx.edu.ittepic.practica4_u4_denisseespinosa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView c1c0,c1c1,c1c2,c1c3,c1c4,
            c2c0,c2c1,c2c2,c2c3,c2c4,c3c0,c3c1,c3c2,c3c3,c3c4;
    TextView c1t,c2t,c3t,c1c0t,c1c1t,c1c2t,c1c3t,c1c4t,
            c2c0t,c2c1t,c2c2t,c2c3t,c2c4t,c3c0t,c3c1t,c3c2t,c3c3t,c3c4t;
    Thread c1,c2,c3, entrada;
    int vcaja1=0,vcaja2=0,vcaja3=0,tcaja1=0,tcaja2=0,tcaja3=0;
    Cola1 col1 = new Cola1();
    Cola2 col2 = new Cola2();
    Cola3 col3 = new Cola3();
    Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1c0 = findViewById(R.id.c1c0);
        c1c1 = findViewById(R.id.c1c1);
        c1c2 = findViewById(R.id.c1c2);
        c1c3 = findViewById(R.id.c1c3);
        c1c4 = findViewById(R.id.c1c4);

        c2c0 = findViewById(R.id.c2c0);
        c2c1 = findViewById(R.id.c2c1);
        c2c2 = findViewById(R.id.c2c2);
        c2c3 = findViewById(R.id.c2c3);
        c2c4 = findViewById(R.id.c2c4);

        c3c0 = findViewById(R.id.c3c0);
        c3c1 = findViewById(R.id.c3c1);
        c3c2 = findViewById(R.id.c3c2);
        c3c3 = findViewById(R.id.c3c3);
        c3c4 = findViewById(R.id.c3c4);

        c1t = findViewById(R.id.c1t);
        c2t = findViewById(R.id.c2t);
        c3t = findViewById(R.id.c3t);

        c1c0t = findViewById(R.id.c1c0t);
        c1c1t = findViewById(R.id.c1c1t);
        c1c2t = findViewById(R.id.c1c2t);
        c1c3t = findViewById(R.id.c1c3t);
        c1c4t = findViewById(R.id.c1c4t);

        c2c0t = findViewById(R.id.c2c0t);
        c2c1t = findViewById(R.id.c2c1t);
        c2c2t = findViewById(R.id.c2c2t);
        c2c3t = findViewById(R.id.c2c3t);
        c2c4t = findViewById(R.id.c2c4t);

        c3c0t = findViewById(R.id.c3c0t);
        c3c1t = findViewById(R.id.c3c1t);
        c3c2t = findViewById(R.id.c3c2t);
        c3c3t = findViewById(R.id.c3c3t);
        c3c4t = findViewById(R.id.c3c4t);

        c1c0.setVisibility(View.INVISIBLE);
        c1c1.setVisibility(View.INVISIBLE);
        c1c2.setVisibility(View.INVISIBLE);
        c1c3.setVisibility(View.INVISIBLE);
        c1c4.setVisibility(View.INVISIBLE);

        c2c0.setVisibility(View.INVISIBLE);
        c2c1.setVisibility(View.INVISIBLE);
        c2c2.setVisibility(View.INVISIBLE);
        c2c3.setVisibility(View.INVISIBLE);
        c2c4.setVisibility(View.INVISIBLE);

        c3c0.setVisibility(View.INVISIBLE);
        c3c1.setVisibility(View.INVISIBLE);
        c3c2.setVisibility(View.INVISIBLE);
        c3c3.setVisibility(View.INVISIBLE);
        c3c4.setVisibility(View.INVISIBLE);

        c1t.setVisibility(View.INVISIBLE);
        c2t.setVisibility(View.INVISIBLE);
        c3t.setVisibility(View.INVISIBLE);

        c1c0t.setVisibility(View.INVISIBLE);
        c1c1t.setVisibility(View.INVISIBLE);
        c1c2t.setVisibility(View.INVISIBLE);
        c1c3t.setVisibility(View.INVISIBLE);
        c1c4t.setVisibility(View.INVISIBLE);

        c2c0t.setVisibility(View.INVISIBLE);
        c2c1t.setVisibility(View.INVISIBLE);
        c2c2t.setVisibility(View.INVISIBLE);
        c2c3t.setVisibility(View.INVISIBLE);
        c2c4t.setVisibility(View.INVISIBLE);

        c3c0t.setVisibility(View.INVISIBLE);
        c3c1t.setVisibility(View.INVISIBLE);
        c3c2t.setVisibility(View.INVISIBLE);
        c3c3t.setVisibility(View.INVISIBLE);
        c3c4t.setVisibility(View.INVISIBLE);

        entrada = new Thread(){
            public void run(){
                while (status = true) {
                    try {
                        sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    int ordenFila[] = {1,2,3};
                    int index, temp;
                    Random random = new Random();
                    for (int i = ordenFila.length - 1; i > 0; i--)
                    {
                        index = random.nextInt(i + 1);
                        temp = ordenFila[index];
                        ordenFila[index] = ordenFila[i];
                        ordenFila[i] = temp;
                    }
                    AsignarColaValor(ordenFila);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mostrarClientes();
                        }
                    });
                }
            }
        };

        c1 = new Thread(){
            public void run(){
                while (status = true) {
                    int dormir = 1000;
                    tcaja1 += vcaja1;
                    if (tcaja1 > 20) {
                        dormir = 27000;
                        vcaja1 = 8;
                    }else {
                        if (col1.ini != -1) {
                            vcaja1 = col1.vector[col1.ini];
                            col1.eliminar();
                            switch (vcaja1) {
                                case 7:
                                    dormir = 17000;
                                    break;
                                case 6:
                                    dormir = 16000;
                                    break;
                                case 5:
                                    dormir = 15000;
                                    break;
                                case 4:
                                    dormir = 14000;
                                    break;
                                case 3:
                                    dormir = 13000;
                                    break;
                                case 2:
                                    dormir = 12000;
                                    break;
                                case 1:
                                    dormir = 11000;
                                    break;
                            }
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mostrarCaja();
                            mostrarClientes();

                        }
                    });
                    try {
                        sleep(dormir);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };


        c2 = new Thread(){
            public void run(){
                while (status = true) {
                    int dormir = 1000;
                    tcaja2 += vcaja2;
                    if (tcaja1 > 20) {
                        dormir = 27000;
                        vcaja2 = 8;
                    }else {
                        if (col2.ini != -1) {
                            vcaja2 = col2.vector[col2.ini];
                            col2.eliminar();
                            switch (vcaja2) {
                                case 7:
                                    dormir = 17000;
                                    break;
                                case 6:
                                    dormir = 16000;
                                    break;
                                case 5:
                                    dormir = 15000;
                                    break;
                                case 4:
                                    dormir = 14000;
                                    break;
                                case 3:
                                    dormir = 13000;
                                    break;
                                case 2:
                                    dormir = 12000;
                                    break;
                                case 1:
                                    dormir = 11000;
                                    break;
                            }
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mostrarCaja();
                            mostrarClientes();

                        }
                    });
                    try {
                        sleep(dormir);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        c3 = new Thread(){
            public void run(){
                while (status = true) {
                    int dormir = 1000;
                    tcaja3 += vcaja3;
                    if (tcaja3 > 20) {
                        dormir = 27000;
                        vcaja3 = 8;
                    }else {
                        if (col3.ini != -1) {
                            vcaja3 = col3.vector[col3.ini];
                            col3.eliminar();
                            switch (vcaja3) {
                                case 7:
                                    dormir = 17000;
                                    break;
                                case 6:
                                    dormir = 16000;
                                    break;
                                case 5:
                                    dormir = 15000;
                                    break;
                                case 4:
                                    dormir = 14000;
                                    break;
                                case 3:
                                    dormir = 13000;
                                    break;
                                case 2:
                                    dormir = 12000;
                                    break;
                                case 1:
                                    dormir = 11000;
                                    break;
                            }
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mostrarCaja();
                            mostrarClientes();

                        }
                    });
                    try {
                        sleep(dormir);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        entrada.start();
        c1.start();
        c2.start();
        c3.start();

    }


    private void AsignarColaValor(int[] ordenFila){
        int numT = (int) (Math.random() * 7) + 1;
        for (int i = 0; i <= ordenFila.length-1;i++){
            String cola1[] = col1.mostrar().split(" ");
            String cola2[] = col2.mostrar().split(" ");
            String cola3[] = col3.mostrar().split(" ");
            int lc1 = cola1.length;
            int lc2 = cola2.length;
            int lc3 = cola3.length;
            if (ordenFila[i] == 1){
                if (col1.fin < 4){
                    if (col1.fin < col2.fin && col2.fin < col3.fin){
                        col1.insertar(numT);
                        return;
                    }else if (col1.fin < col2.fin && col2.fin == col3.fin){
                        col1.insertar(numT);
                        return;
                    }else if (col1.fin == col2.fin && col2.fin < col3.fin){
                        col1.insertar(numT);
                        return;
                    }else if (col1.fin == col2.fin && col2.fin == col3.fin){
                        col1.insertar(numT);
                        return;
                    }
                }else if (lc1 < 5){
                    if (lc1 < lc2 && lc2 < lc3){
                        col1.insertar(numT);
                        return;
                    }else if (lc1 < lc2 && lc2 == lc3){
                        col1.insertar(numT);
                        return;
                    }else if (lc1 == lc2 && lc2 < lc3){
                        col1.insertar(numT);
                        return;
                    }else if (lc1 == lc2 && lc2 == lc3){
                        col1.insertar(numT);
                        return;
                    }
                }
            }else if (ordenFila[i] == 2){
                if (col2.fin < 4){
                    if (col2.fin < col1.fin && col1.fin < col3.fin) {
                        col2.insertar(numT);
                        return;
                    }else if (col2.fin < col1.fin && col1.fin == col3.fin) {
                        col2.insertar(numT);
                        return;
                    }else if (col2.fin == col1.fin && col1.fin < col3.fin) {
                        col2.insertar(numT);
                        return;
                    }else if (col2.fin == col1.fin && col1.fin == col3.fin) {
                        col2.insertar(numT);
                        return;
                    }
                }else if (lc2 < 5){
                    if (lc2 < lc1 && lc1 < lc3){
                        col2.insertar(numT);
                        return;
                    }else if (lc2 < lc1 && lc1 == lc3){
                        col2.insertar(numT);
                        return;
                    }else if (lc2 == lc1 && lc1 < lc3){
                        col2.insertar(numT);
                        return;
                    }else if (lc2 == lc1 && lc1 == lc3){
                        col2.insertar(numT);
                        return;
                    }
                }
            }else if (ordenFila[i] == 3){
                if (col3.fin < 4){
                    if (col3.fin < col2.fin && col2.fin < col1.fin) {
                        col3.insertar(numT);
                        return;
                    }else if (col3.fin < col2.fin && col2.fin == col1.fin) {
                        col3.insertar(numT);
                        return;
                    }else if (col3.fin == col2.fin && col2.fin < col1.fin) {
                        col3.insertar(numT);
                        return;
                    }else if (col3.fin == col2.fin && col2.fin == col1.fin) {
                        col3.insertar(numT);
                        return;
                    }
                }else if (lc3 < 5){
                    if (lc3 < lc2 && lc2 < lc1){
                        col3.insertar(numT);
                        return;
                    }else if (lc3 < lc2 && lc2 == lc1){
                        col3.insertar(numT);
                        return;
                    }else if (lc3 == lc2 && lc2 < lc1){
                        col3.insertar(numT);
                        return;
                    }else if (lc3 == lc2 && lc2 == lc1){
                        col3.insertar(numT);
                        return;
                    }
                }
            }
        }
    }

    private void mostrarClientes(){
        String cola1[] = col1.mostrar().split(" ");
        String cola2[] = col2.mostrar().split(" ");
        String cola3[] = col3.mostrar().split(" ");
        int lc1 = cola1.length;
        int lc2 = cola2.length;
        int lc3 = cola3.length;
        if (col1.ini != -1){
            if (lc1 >= 1){
                c1c0.setVisibility(View.VISIBLE);
                c1c0t.setText(cola1[0]+"");
                c1c0t.setVisibility(View.VISIBLE);
            }
            if (lc1 >= 2){
                c1c1.setVisibility(View.VISIBLE);
                c1c1t.setText(cola1[1]);
                c1c1t.setVisibility(View.VISIBLE);
            }
            if (lc1 >= 3){
                c1c2.setVisibility(View.VISIBLE);
                c1c2t.setText(cola1[2]);
                c1c2t.setVisibility(View.VISIBLE);
            }
            if (lc1 == 4){
                c1c3.setVisibility(View.VISIBLE);
                c1c3t.setText(cola1[3]);
                c1c3t.setVisibility(View.VISIBLE);
            }
            if (lc1 == 5){
                c1c4.setVisibility(View.VISIBLE);
                c1c4t.setText(cola1[4]);
                c1c4t.setVisibility(View.VISIBLE);
            }
        }
        if (col2.ini != -1){
            if (lc2 >= 1){
                c2c0.setVisibility(View.VISIBLE);
                c2c0t.setText(cola2[0]);
                c2c0t.setVisibility(View.VISIBLE);
            }
            if (lc2 >= 2){
                c2c1.setVisibility(View.VISIBLE);
                c2c1t.setText(cola2[1]);
                c2c1t.setVisibility(View.VISIBLE);
            }
            if (lc2 >= 3){
                c2c2.setVisibility(View.VISIBLE);
                c2c2t.setText(cola2[2]);
                c2c2t.setVisibility(View.VISIBLE);
            }
            if (lc2 == 4){
                c2c3.setVisibility(View.VISIBLE);
                c2c3t.setText(cola2[3]);
                c2c3t.setVisibility(View.VISIBLE);
            }
            if (lc2 == 5){
                c2c4.setVisibility(View.VISIBLE);
                c2c4t.setText(cola2[4]);
                c2c4t.setVisibility(View.VISIBLE);
            }
        }
        if (col3.ini != -1){
            if (lc3 >= 1){
                c3c0.setVisibility(View.VISIBLE);
                c3c0t.setText(cola3[0]);
                c3c0t.setVisibility(View.VISIBLE);
            }
            if (lc3 >= 2){
                c3c1.setVisibility(View.VISIBLE);
                c3c1t.setText(cola3[1]);
                c3c1t.setVisibility(View.VISIBLE);
            }
            if (lc3 >= 3){
                c3c2.setVisibility(View.VISIBLE);
                c3c2t.setText(cola3[2]);
                c3c2t.setVisibility(View.VISIBLE);
            }
            if (lc3 == 4){
                c3c3.setVisibility(View.VISIBLE);
                c3c3t.setText(cola3[3]);
                c3c3t.setVisibility(View.VISIBLE);
            }
            if (lc3 == 5){
                c3c4.setVisibility(View.VISIBLE);
                c3c4t.setText(cola3[4]);
                c3c4t.setVisibility(View.VISIBLE);
            }
        }
    }

    private void mostrarCaja(){
        if (vcaja1 != 0) {
            if (vcaja1 == 8) {
                vcaja1=0;
                tcaja1=0;
                c1t.setText("");
                c1t.setVisibility(View.VISIBLE);
                c1c0.setVisibility(View.INVISIBLE);
                c1c1.setVisibility(View.INVISIBLE);
                c1c2.setVisibility(View.INVISIBLE);
                c1c3.setVisibility(View.INVISIBLE);
                c1c4.setVisibility(View.INVISIBLE);
                c1c0t.setVisibility(View.INVISIBLE);
                c1c1t.setVisibility(View.INVISIBLE);
                c1c2t.setVisibility(View.INVISIBLE);
                c1c3t.setVisibility(View.INVISIBLE);
                c1c4t.setVisibility(View.INVISIBLE);
            }else {
                c1t.setText(vcaja1 + "");
                c1t.setVisibility(View.VISIBLE);
                c1c0.setVisibility(View.INVISIBLE);
                c1c1.setVisibility(View.INVISIBLE);
                c1c2.setVisibility(View.INVISIBLE);
                c1c3.setVisibility(View.INVISIBLE);
                c1c4.setVisibility(View.INVISIBLE);
                c1c0t.setVisibility(View.INVISIBLE);
                c1c1t.setVisibility(View.INVISIBLE);
                c1c2t.setVisibility(View.INVISIBLE);
                c1c3t.setVisibility(View.INVISIBLE);
                c1c4t.setVisibility(View.INVISIBLE);
            }
        }
        if (vcaja2 != 0) {
            if (vcaja2 == 8) {
                vcaja2=0;
                tcaja2=0;
                c2t.setText("");
                c2t.setVisibility(View.VISIBLE);
                c2c0.setVisibility(View.INVISIBLE);
                c2c1.setVisibility(View.INVISIBLE);
                c2c2.setVisibility(View.INVISIBLE);
                c2c3.setVisibility(View.INVISIBLE);
                c2c4.setVisibility(View.INVISIBLE);
                c2c0t.setVisibility(View.INVISIBLE);
                c2c1t.setVisibility(View.INVISIBLE);
                c2c2t.setVisibility(View.INVISIBLE);
                c2c3t.setVisibility(View.INVISIBLE);
                c2c4t.setVisibility(View.INVISIBLE);
            }else {
                c2t.setText(vcaja2 + "");
                c2t.setVisibility(View.VISIBLE);
                c2c0.setVisibility(View.INVISIBLE);
                c2c1.setVisibility(View.INVISIBLE);
                c2c2.setVisibility(View.INVISIBLE);
                c2c3.setVisibility(View.INVISIBLE);
                c2c4.setVisibility(View.INVISIBLE);
                c2c0t.setVisibility(View.INVISIBLE);
                c2c1t.setVisibility(View.INVISIBLE);
                c2c2t.setVisibility(View.INVISIBLE);
                c2c3t.setVisibility(View.INVISIBLE);
                c2c4t.setVisibility(View.INVISIBLE);
            }
        }
        if (vcaja3 != 0) {
            if (vcaja3 == 8) {
                vcaja3=0;
                tcaja3=0;
                c3t.setText("");
                c3t.setVisibility(View.VISIBLE);
                c3c0.setVisibility(View.INVISIBLE);
                c3c1.setVisibility(View.INVISIBLE);
                c3c2.setVisibility(View.INVISIBLE);
                c3c3.setVisibility(View.INVISIBLE);
                c3c4.setVisibility(View.INVISIBLE);
                c3c0t.setVisibility(View.INVISIBLE);
                c3c1t.setVisibility(View.INVISIBLE);
                c3c2t.setVisibility(View.INVISIBLE);
                c3c3t.setVisibility(View.INVISIBLE);
                c3c4t.setVisibility(View.INVISIBLE);
            }else {
                c3t.setText(vcaja3 + "");
                c3t.setVisibility(View.VISIBLE);
                c3c0.setVisibility(View.INVISIBLE);
                c3c1.setVisibility(View.INVISIBLE);
                c3c2.setVisibility(View.INVISIBLE);
                c3c3.setVisibility(View.INVISIBLE);
                c3c4.setVisibility(View.INVISIBLE);
                c3c0t.setVisibility(View.INVISIBLE);
                c3c1t.setVisibility(View.INVISIBLE);
                c3c2t.setVisibility(View.INVISIBLE);
                c3c3t.setVisibility(View.INVISIBLE);
                c3c4t.setVisibility(View.INVISIBLE);
            }
        }
    }


    public void caja1(View v){
        c1.start();
    }

    public void caja2(View v){
        c2.start();
    }

    public void caja3(View v){
        c3.start();
    }


}
