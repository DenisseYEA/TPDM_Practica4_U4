package mx.edu.ittepic.practica4_u4_denisseespinosa;

/**
 * Created by denisseyea on 6/12/18.
 */

public class Cola1 {
    int vector[] = new int[5];
    int ini=-1,fin=-1;

    private void RealizarAcarreo(){
        int t1,t2;
        for (t1 = 0, t2=ini; t2<=fin; t1++,t2++) {
            vector[t1]=vector[t2];
        }
        ini=0;
        fin=t1-1;
    }

    public boolean insertar(int valor){
        if(fin==vector.length-1){
            if(ini>0){
                RealizarAcarreo();
            }
        }
        fin++;
        vector[fin]=valor;
        if(ini==-1){
            ini=0;
        }
        return true;
    }

    public boolean eliminar(){
        if(ini==-1 && fin==-1){
            return false;
        }
        //condición de un solo elemento
        if(ini==fin){
            ini=fin=-1;
            return true;
        }
        //esta parte si hay 2 o más elementos
        ini++;
        return true;
    }

    public String mostrar(){
        if(ini==-1 && fin==-1){
            return "";
        }
        String resultado="";
        for (int i = ini; i <= fin; i++) {
            resultado+=vector[i]+" ";
        }
        return resultado;
    }

}
