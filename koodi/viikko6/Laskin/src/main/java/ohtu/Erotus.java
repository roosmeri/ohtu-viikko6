package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Viliina
 */
public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        this.edellinen = sovellus.tulos();
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + edellinen);
    }

}
