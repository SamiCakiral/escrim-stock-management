package com.webapp.mvc.stock;

import java.util.Date;

import com.webapp.mvc.materiel.MaterielMedical;


/**
 * Cette classe représente une commande de matériel médical.
 * Elle contient des informations sur l'identifiant de la commande, la date de commande,
 * l'état de la commande et les articles commandés.
 *
 * @author CS
 */
public class Commande {
    private int id;
    private Date dateCommande;
    private String etat;
    private MaterielMedical[] articles;

    /**
     * Constructeur de la classe Commande.
     *
     * @param id            l'identifiant de la commande
     * @param dateCommande  la date de commande
     * @param etat          l'état de la commande
     * @param articles      les articles commandés
     */
    public Commande(int id, Date dateCommande, String etat, MaterielMedical[] articles) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.etat = etat;
        this.articles = articles;
    }

    /**
     * Ajoute un article à la commande.
     *
     * @param article l'article à ajouter
     */
    public void ajouterArticle(MaterielMedical article) {
        // TODO: Implement ajouterArticle method
    }

    /**
     * Retire un article de la commande.
     *
     * @param article l'article à retirer
     */
    public void retirerArticle(MaterielMedical article) {
        // TODO: Implement retirerArticle method
    }

    /**
     * Valide la commande.
     */
    public void validerCommande() {
        // TODO: Implement validerCommande method
    }

    /**
     * Annule la commande.
     */
    public void annulerCommande() {
        // TODO: Implement annulerCommande method
    }

    /**
     * Retourne l'identifiant de la commande.
     *
     * @return l'identifiant de la commande
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de la commande.
     *
     * @param id le nouvel identifiant de la commande
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne la date de commande.
     *
     * @return la date de commande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * Modifie la date de commande.
     *
     * @param dateCommande la nouvelle date de commande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * Retourne l'état de la commande.
     *
     * @return l'état de la commande
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Modifie l'état de la commande.
     *
     * @param etat le nouvel état de la commande
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * Retourne les articles de la commande.
     *
     * @return les articles de la commande
     */
    public MaterielMedical[] getArticles() {
        return articles;
    }

    /**
     * Modifie les articles de la commande.
     *
     * @param articles les nouveaux articles de la commande
     */
    public void setArticles(MaterielMedical[] articles) {
        this.articles = articles;
    }
}
