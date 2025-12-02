package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import Musique.Utilisateur;

public class JSONUtils {
    public static void exporterUtilisateurJSON(Utilisateur u) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
        System.out.println(json);
    }
}
