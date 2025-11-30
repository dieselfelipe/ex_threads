    package parte2;

    public class Download implements Runnable {

    private String nomeArquivo;
    private int tamanhoTotal; 
    private double velocidadeMbps; 

    public Download(String nomeArquivo, int tamanhoTotal, double velocidadeMbps) {
        this.nomeArquivo = nomeArquivo;
        this.tamanhoTotal = tamanhoTotal;
        this.velocidadeMbps = velocidadeMbps;
    }

    @Override
    public void run() {

        System.out.println(nomeArquivo + ": download iniciado!");

        double velocidadeMBps = velocidadeMbps / 8.0; 
        int intervaloMs = 100; 
        double intervaloSeg = intervaloMs / 1000.0;

        double tamanhoBaixado = 0;

        while (tamanhoBaixado < tamanhoTotal) {

            double baixadoIntervalo = velocidadeMBps * intervaloSeg;

            tamanhoBaixado += baixadoIntervalo;

            if (tamanhoBaixado > tamanhoTotal) {
                tamanhoBaixado = tamanhoTotal;
            }

            System.out.println(nomeArquivo + ": " + tamanhoBaixado + "/" + tamanhoTotal + " MB");

            try {
                Thread.sleep(intervaloMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("o arquivo: " + nomeArquivo + " foi baixado com sucesso");
    }
}