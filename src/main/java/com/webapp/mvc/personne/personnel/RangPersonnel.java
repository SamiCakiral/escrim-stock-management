package com.webapp.mvc.personne.personnel;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe représente les rangs du personnel.
 * Elle fournit des méthodes pour obtenir les abréviations des rangs, 
 * obtenir le rang à partir de l'abréviation, vérifier si un rang existe, 
 * et vérifier si une abréviation existe.
 * 
 * @author CS
 */
public class RangPersonnel {
    private static final Map<String, String> RANK_ABBREVIATIONS = new HashMap<>();
    
    static {
        RANK_ABBREVIATIONS.put("Soldat", "Sdt");
        RANK_ABBREVIATIONS.put("Caporal", "Cpl");
        RANK_ABBREVIATIONS.put("Sergent", "Sgt");
        RANK_ABBREVIATIONS.put("Adjudant", "Adj");
        RANK_ABBREVIATIONS.put("Lieutenant", "Lt");
        RANK_ABBREVIATIONS.put("Capitaine", "Cpt");
        RANK_ABBREVIATIONS.put("Commandant", "Cmdt");
        RANK_ABBREVIATIONS.put("Colonel", "Col");
        RANK_ABBREVIATIONS.put("Général", "Gén");
        RANK_ABBREVIATIONS.put("Docteur", "Dr");
    }

    /**
     * Renvoie l'abréviation correspondant au rang spécifié.
     * 
     * @param rank le rang pour lequel obtenir l'abréviation
     * @return l'abréviation correspondant au rang spécifié, ou null si le rang n'existe pas
     */
    public String getAbbreviation(String rank) {
        return RANK_ABBREVIATIONS.get(rank);
    }

    /**
     * Renvoie le rang correspondant à l'abréviation spécifiée.
     * 
     * @param abbreviation l'abréviation pour laquelle obtenir le rang
     * @return le rang correspondant à l'abréviation spécifiée, ou null si l'abréviation n'existe pas
     */
    public static String getRank(String abbreviation) {
        for (Map.Entry<String, String> entry : RANK_ABBREVIATIONS.entrySet()) {
            if (entry.getValue().equals(abbreviation)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Vérifie si le rang spécifié existe.
     * 
     * @param rank le rang à vérifier
     * @return true si le rang existe, sinon false
     */
    public static boolean isRank(String rank) {
        return RANK_ABBREVIATIONS.containsKey(rank);
    }

    /**
     * Vérifie si l'abréviation spécifiée existe.
     * 
     * @param abbreviation l'abréviation à vérifier
     * @return true si l'abréviation existe, sinon false
     */
    public static boolean isAbbreviation(String abbreviation) {
        return RANK_ABBREVIATIONS.containsValue(abbreviation);
    }
}
