/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fran
 */
public class MatarProcesos {
    static class MiProceso {
        int id;
        Process p;
        MiProceso(Process p, int id){
            this.p=p;
            this.id=id;
        }
        @Override
        public boolean equals(Object o){
            MiProceso mp=(MiProceso)o;
            return (id==mp.id);
        }
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList<MiProceso> lista = new ArrayList<MiProceso>();
        Scanner teclado = new Scanner(System.in);
        int id;
        for (int i = 0; i < 5; i++) {
            lista.add(new MiProceso(Runtime.getRuntime()
                                    .exec("calc.exe"),i));
        }
        do {
            System.out.println("Elige el proceso que quieres eliminar:");
            id = teclado.nextInt();
            int pos =lista.indexOf(new MiProceso(null,id));
            if (pos!=-1){
                lista.get(pos).p.destroy();
                lista.remove(pos);
            }
        
        } while (id != 5);
    }
}