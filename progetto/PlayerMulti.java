
package progetto;

import java.util.Scanner;

// Interfaccia per gli elementi riproducibili
interface Riproducibile {
    void play();
}

// Classe astratta per gli elementi multimediali
abstract class ElementoMultimediale {
    String titolo;

    ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    // Metodo per eseguire l'elemento multimediale
    public abstract void esegui();
}

// Classe concreta per le registrazioni audio
class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    int durata;
    int volume;

    RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    // Metodo per riprodurre la registrazione audio
    public void play() {
        for (int i = 0; i < durata; i++) {

                System.out.println(titolo + " " + "!".repeat(volume));

        }
    }

    // Metodo per eseguire la registrazione audio
    public void esegui() {
        play();
    }
}

// Classe concreta per i video
class Video extends ElementoMultimediale implements Riproducibile {
    int durata;
    int volume;
    int luminosita;

    Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    // Metodo per riprodurre il video
    public void play() {

        for (int i = 0; i < durata; i++) {

                System.out.println(titolo + " " + "!".repeat(volume) + "*".repeat(luminosita));

        }
    }

    // Metodo per eseguire il video
    public void esegui() {
        play();
    }
}

// Classe concreta per le immagini
class Immagine extends ElementoMultimediale {
    int luminosita;

    Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    // Metodo per visualizzare l'immagine
    void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }

    // Metodo per eseguire l'immagine
    public void esegui() {
        show();
    }
}

public class PlayerMulti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Creazione degli elementi da tastiera
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();
            System.out.println("Inserisci la durata:");
            int durata = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci il tipo (1 = Registrazione Audio, 2 = Video, 3 = Immagine):");
            int tipo = Integer.parseInt(scanner.nextLine());
            switch (tipo) {
                case 1:
                    System.out.println("Inserisci il volume:");
                    int volume = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
                    break;
                case 2:
                    System.out.println("Inserisci il volume:");
                    volume = Integer.parseInt(scanner.nextLine());
                    System.out.println("Inserisci la luminosita:");
                    int luminosita = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Video(titolo, durata, volume, luminosita);
                    break;
                case 3:
                    System.out.println("Inserisci la luminosita:");
                    luminosita = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;
                default:
                    System.out.println("Tipo non valido.");
            }
        }

        // Esecuzione degli elementi
        int scelta;
        do {
            System.out.println("Quale elemento eseguire? (1-5, 0 per uscire)");
            scelta = Integer.parseInt(scanner.nextLine());
            if (scelta >= 1 && scelta <= 5) {
                if (elementi[scelta - 1] instanceof Riproducibile) {
                    ((Riproducibile) elementi[scelta - 1]).play();
                } else if (elementi[scelta - 1] instanceof Immagine) {
                    ((Immagine) elementi[scelta - 1]).show();
                } else {
                    System.out.println("Elemento non riproducibile.");
                }
            } else {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }
}
