package Stats;

import java.util.*;

import Musique.Album;
import Musique.Artiste;
import Musique.Morceau;

public class Classement {

    public static List<Artiste> artistesParRevenus(List<Artiste> artistes) {
        List<Artiste> copy = new ArrayList<>(artistes);
        copy.sort((a1, a2) -> Double.compare(a2.getRoyaltiesCarriere(), a1.getRoyaltiesCarriere()));
        return copy;
    }
    
    public static List<Morceau> titresLesPlusEcoutes(List<Morceau> morceaux) {
        List<Morceau> copy = new ArrayList<>(morceaux);
        copy.sort((m1, m2) -> Integer.compare(m2.getNbEcoutes(), m1.getNbEcoutes()));
        return copy;
    }

    public static Album albumLePlusEcoute(List<Album> albums) {
        return Collections.max(albums, Comparator.comparingInt(Album::getNbEcoutes));
    }

}
