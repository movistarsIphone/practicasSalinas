public class Hilos {
    static void mensajeHilo(String mensaje) {
        System.out.println("Mensaje del hilo: "+ mensaje);
    }

    static class MensajesHilos implements Runnable {
        public void run() {
            String himnoNacional[] = {
                    "----------Mexicanos, al grito de guerra.----------",
                    "----------El acero aprestad y el bridón.----------",
                    "----------Y retiemble en sus centros la tierra.----------",
                    "----------Al sonoro rugir del cañón.----------"
            };
            try {
                for (int i = 0;
                     i < himnoNacional.length;
                     i++) {
                    // Pausa de 2 segundos
                    Thread.sleep(4000);
                    // Imprimir una seccion del himno nacional
                    mensajeHilo(himnoNacional[i]);
                }
            } catch (InterruptedException e) {
                mensajeHilo("¡Aún no termina el himno nacional!");
            }
        }
    }

}
