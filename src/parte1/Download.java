package parte1;
public class Download implements Runnable {

    private String nomeArquivo;
    private int tamanhoTotal;

    public Download(String nomeArquivo, int tamanhoTotal) {
        this.nomeArquivo = nomeArquivo;
        this.tamanhoTotal = tamanhoTotal;
    }

    @Override
    public void run() {
        int tamanhoBaixado = 0;

        System.out.println(nomeArquivo + ": Download iniciado!");

        while (tamanhoBaixado < tamanhoTotal) {

            int chunk = (int) (Math.random() * 25) + 1;
            tamanhoBaixado += chunk;

            if (tamanhoBaixado > tamanhoTotal) {
                tamanhoBaixado = tamanhoTotal;
            }

            System.out.println(nomeArquivo + ": " + tamanhoBaixado + "/" + tamanhoTotal + " MB");

            try {
                Thread.sleep((long) (Math.random() * 151)); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("o arquivo: " + nomeArquivo + " foi baixado com sucesso");
    }
}