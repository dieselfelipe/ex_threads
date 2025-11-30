package parte1;
public class GeraDownloads {

    public static void main(String[] args) {

        Download d1 = new Download("Filme_HD.mp4", 1200);
        Download d2 = new Download("Musica.mp3", 5);
        Download d3 = new Download("Jogo_Update.iso", 4500);
        Download d4 = new Download("Documento.pdf", 20);

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d3);
        Thread t4 = new Thread(d4);

        System.out.println("Iniciando downloads simultâneos... ");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}