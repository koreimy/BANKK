/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancaire;

import static comptebancaire.Operation.sc;
import static comptebancaire.Operation_donnees.Calculer_Interet;
import static comptebancaire.Operation_donnees.Depot_Argent;
import static comptebancaire.Operation_donnees.Produire_Rapport;
import static comptebancaire.Operation_donnees.Recherche_comptes;
import static comptebancaire.Operation_donnees.consulter_compte;
import static comptebancaire.Operation_donnees.creer_Compte;
import static comptebancaire.Operation_donnees.retrait_Argent;

/**
 *
 * @author brahim
 */
public class Interface_Accueil {
    public static void Interface_Accueil() {
           System.out.println("|===========================================================|\n"
                            + "|              Gestion des comptes bancaires                |\n"
                            + "|===========================================================|\n");
        int Ut;
        do {
            System.out.println("===============================================================");
            System.out.println("              Menu principal                                   ");
            System.out.println("===============================================================");
            System.out.println("Taper le numero vous correspont");
            System.out.println("1-Gestionnaire\n" + "2-Guichetier\n" + "3-Client\n"+"0-Quitter");
            System.out.println("Veuillez choisir un numero qui se trouve entre 1 et 3 pour continuer sinon 0");
            System.out.println("================================================================");
            Ut = sc.nextInt();
            if(Ut==1 |Ut==2|Ut==3|Ut==0){
            switch (Ut) {
                case 1:
                    System.out.println("           Accueil Gestionnaire                                ");
                    System.out.println("===============================================================");
                    System.out.println("Quelle opération vouleez-vous effectué?");
                    System.out.println("1-Créer un compte");
                    System.out.println("2-Suprimer un comptee");
                    System.out.println("3-Consulter un compte");
                    System.out.println("4-Calculer intérêt et mise à jour");
                    System.out.println("5-Produire rapport");
                    System.out.println("6-Rechercher des comptes");
                    System.out.println("Veuillez choisir un numero qui se trouve entre 1 et 6 pour continuer sinon 0");
                    System.out.println("===============================================================");
                    int Ut1 = sc.nextInt();
                    if(Ut1==1 |Ut1==2|Ut1==3|Ut1==4|Ut1==5|Ut1==6){
                     switch (Ut1){
                         case 1:
                    creer_Compte();
                    break;
                         case 2:
                             System.out.println("ce service n'est pas disponible");
                             break;
                         case 3:
                             consulter_compte();
                             break;
                         case 4:
                             Calculer_Interet();
                             break;
                         case 5:
                            Produire_Rapport();
                            break;
                         case 6:
                           Recherche_comptes();
                     }   
                    }else{
                       System.out.println("Vous avez saisi un mauvais numero"); 
                    }
                      
                    break;
                case 2:
                    System.out.println("             Accueil Guichetier                                ");
                    System.out.println("===============================================================");
                    System.out.println("1-Deposer argent");
                    System.out.println("2 Retirer argent");
                    System.out.println("3-Consulter un compte");
                    System.out.println("===============================================================");
                    int op = sc.nextInt();
                    if(op==1 | op==2 |op==3){
                    switch (op) {
                        case 1:
                            Depot_Argent();
                            break;
                        case 2:
                            retrait_Argent();
                            break;
                        case 3:
                             consulter_compte();
                    }
                    break;
                    }else{
                            System.out.println("Vous avez saisi un mauvais numero");
                          }
                case 3:
                    System.out.println("Saisissez votre numero de compte");
                    consulter_compte();
                    break;
            }
            }else{
                    System.out.println("Vous avez saisi un mauvais numero");
                    }
            
        } while (Ut != 0);

    }

    
}
