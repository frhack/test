
public class Search1 extends Thread {
    private int[] v; // vettore dei valori
    private int a; // indice minimo+
    private int b; // indice massimo
    private int e; // elemento da ricercare
    private int n; // conteggio occorrenze
    private String nome;

    public Search1(String nome, int[] v, int a, int b, int e) {
        this.nome = nome; //dfsdfsd
        this.v = v;
        this.a = a;
        this.b = b;
        this.e = e;
        this.n = 0;
    }

    public int conteggio() {
        return n;
    }

    @Override
    public void run() {
        System.out.println("Thread " + nome + " partito.");


        for (int i = a; i < b; i++) {
            try {
                Thread.sleep(1); // simuliamo operazione costosa 
            } catch (Exception e) {
                // TODO: handle exception
            }
        if (v[i] == e) {
                n++;
            }
        }
        System.out.println(nome + " ha trovato " + n + " occorrenze.");
    }

    public static void main(String args[]) {
        int[] vettore = new int[10000];
        java.util.Random generatore = new java.util.Random();
        for (int i = 0; i < vettore.length; i++)
            vettore[i] = generatore.nextInt() % 30;

        var thread1 = new  Search1("1", vettore, 0, vettore.length / 2, 0);
        var thread2 =  new Search1("2", vettore, vettore.length / 2, vettore.length, 0);
        var thread3 = new Search1("3", vettore, 0, vettore.length, 0);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            System.out.println(
                    "Threads 1 e 2 hanno trovato " + (thread1.conteggio() + thread2.conteggio()) + " occorrenze.");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
