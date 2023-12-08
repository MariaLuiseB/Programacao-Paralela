import java.util.logging.Level;
import java.util.logging.Logger;


public class Cruzamento_Semaforo {
    public static void main(String[] args) {
        Thread s1 = new Thread(new Semaforo1(), "Semaforo 1");

        //Thread s2 = new Thread(new Semaforo2(), "\tSemaforo 2");

        System.out.println("Iniciando threads...");
        s1.start();
        //a.start();
        //c.start();

        //x.start();
        //y.start();
        
        //garante que o main espere a thread x terminar para depois executar
        // testa com join e testa sem, repare no Main feito
        try {
            s1.join();
            //y.join();
           //a.join();
           //b.join();
           //c.join();
        } catch (InterruptedException ex) {
           Logger.getLogger(Cruzamento_Semaforo.class.getName()).log(Level.SEVERE, null, ex);
        }
// deixa as outras threads iniciar a execução.
        Thread.yield();
        System.out.println("Main feito");
    }

}

class Semaforo1 implements Runnable {

    @Override
    public void run() {
        String s1 = Thread.currentThread().getName();
        try {
            System.out.println("Semaforo 1:" + s1);
            System.out.println("VERDE");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.exit(0);
        }
    }
}


