package com.luisgomez;

import java.util.Random;

public class Tortuga extends Thread {

    private String nombre;

    private int casillas;

    private int tiempoEntreHilos=1;

    public Tortuga(String name, int casillas) {
        super(name);
        this.casillas = casillas;
    }


    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }


    @Override
    public void run() {


        while (casillas < 70){


            // EXPLICACION (*)

            Random random = new Random();

            int numRandom = random.nextInt(100) + 1; // Genera desde 0 a 99, (el 100 no lo incluye, por tanto le sumamos 1
            // asi obtenemos numeros aleatorios desde 1 hasta 100


            if(numRandom>0&&numRandom<=50){

                casillas +=3;

            } else if (numRandom>50&&numRandom<=70){

                casillas -=6;

            } else if (numRandom>70&&numRandom<=100){

                casillas +=1;

            }

            // Para que no haya valores por debajo de cero
            if(casillas <0){

                casillas =0;
            }

            // LLamamos al metodo para que aplique e tiempo de espera para volver a imprimir

            this.esperarXsegundos(tiempoEntreHilos);

            // Con this.getName, obtenemos el nombre de la clase como otras veces, pero en este caso casi q ponerlo a mano

            System.out.println(this.getName() + " - " + casillas + " casillas.");


        }

        // Si ha llegado a 70 casillas entonces imprime que ha terminado

        System.out.println(Thread.currentThread().getName() + " ha llegado a la meta ");
    }


    private void esperarXsegundos(int segundos){
        try{
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

}
