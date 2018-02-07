
package comptebancaire;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brahim
 */
/* constructeur compte*/
public class Compte {
   private int numero;
   private static  Client client;
   private double solde;
   private  int tauxIntere;
  static ArrayList<Compte> TCptes = new ArrayList<Compte>();
   /* la classe compe*/
   public  Compte(int numero, Client c, double solde,int tauxInter ){
   //super();
   this.numero = numero;
   this.tauxIntere = tauxInter;
   client = c;
   this.solde=solde;
   }
   
  /*constructeur d'affectation de taux d'interet
   public Compte(int numero, Client C, float tauxIntere){
       this(numero, C);
       this.tauxIntere = tauxIntere;
   }*/
   /* la fonction qui renvoie la solde d'un compte*/
   public double getSolde(){
   return solde;
   }
   
   /* la fonction qui renvoie le proprietaire de compte*/
   public Client getClient(){
   return client;
   }
   /* la fonction qui renvoie le numero de compte*/
   public int getNumero(){
   return numero;
   }
   public double getTauxInteret(){
   return tauxIntere;}
   
   public void setNumero(int NumeroCpt){
       this.numero = NumeroCpt;
   }
   public void setTauxInteret(int Tx){
   this.tauxIntere = Tx;}
   
   public void setSolde(double nSolde){
       this.solde=nSolde;
   }
   /* la fonction qui credite un compte*/
   public void  crediteCpt(double mnt){
       solde+=mnt;
      // return solde;
   }
    //la fonction qui permet de faire le retrait
   public void retraitArgent(double montant){
   double retraitSolde = solde - montant;
   if(solde >= montant && montant > 0)
   {
   solde = retraitSolde;
   System.out.println("Opération effectuée");
   }
   else
   {
   System.out.println("retrait impossible, veuillez voir le gestionnaire");
   }
   }
   
   /* la fonction qui renvoie une chaine de caractere*/
   
   public  String toString(){
   String rep="";
        //if((Client != null)&&Client.cptes.size()>0)
        for(int i = 0; i < TCptes.size(); i++){
        rep="Numero compte " +i + TCptes.get(i).getNumero() + TCptes.get(i).getClient().getNom()+" Solde:" + TCptes.get(i).getSolde();
        //rep = numOp + "| " + libOp + "| " + mntOp + "| " + sensOp + "| " + dateOp + "|" + numCptOp;
        }
       return rep;
   }
   public static void Liste_compte( ArrayList<Compte> TCptes,
ArrayList<Client> cptes){
         for(int i = 0; i < TCptes.size(); i++){
           System.out.println("Enregistrement N° " + (i+1) + " : " +
                   " Numero de compte:" +" " +String.format(" %03d", TCptes.get(i).getNumero()) + " " +
                   " Nom:"+" "+cptes.get(i).getNom()+" " +
                  " Numero identifiant:" +" " +cptes.get(i).getNumero()+" " +
                   "Solde =" + TCptes.get(i).getSolde()+"euros " +" " +
                   " Taux d'intérêt:" +TCptes.get(i).getTauxInteret()+" %" );
              }
           
     }
    
   /*
   // methode qui permet de calculer l'interet
   static  double CalculInteret(){
   double intere = (solde * durée* tauxIntere)/100;
   return intere;
   }
   */
   //methode qui permet de creer un copmte
  
}

