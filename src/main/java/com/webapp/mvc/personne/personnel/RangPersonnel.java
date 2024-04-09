package com.webapp.mvc.personne.personnel;
import java.util.HashMap;
import java.util.Map;

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

    public String getAbbreviation(String rank) {
        return RANK_ABBREVIATIONS.get(rank);
    }

    public static String getRank(String abbreviation) {
        for (Map.Entry<String, String> entry : RANK_ABBREVIATIONS.entrySet()) {
            if (entry.getValue().equals(abbreviation)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static boolean isRank(String rank) {
        return RANK_ABBREVIATIONS.containsKey(rank);
    }

    public static boolean isAbbreviation(String abbreviation) {
        return RANK_ABBREVIATIONS.containsValue(abbreviation);
    }

    
}
