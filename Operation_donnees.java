package comptebancaire;

//import static comptebancaire.Compte.Liste_compte;
import static comptebancaire.Compte.TCptes;
import static comptebancaire.Operation.sc;
import java.util.Scanner;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author brahim
 */
public class Operation_donnees {
     public static void creer_Compte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le numéro d’identification du titulaire du compte: ");
        int nCl1 = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Entrer le nom du titulaire: ");
        String nCl = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Entrer le numéro  du compte: ");
        int nCpt = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Entrer le montant à la création: ");
        double solde = sc3.nextDouble();
        System.out.println("Entrer le taux d'intérêt de ce compte: ");
        Scanner sc4 = new Scanner(System.in);
        int tIn = sc4.nextInt();
        Client cl = new Client(nCl1, nCl);
        Client.cptes.add(cl);
        Compte cpt = new Compte(nCpt, cl, solde,tIn);
        Compte.TCptes.add(cpt);
        
        if((cl != null)&&Compte.TCptes.size()>0){
           System.out.println("opération effectuée avec succée  ");
         }else{
             System.out.println("Echec de création du compte");
         }
           
       System.out.println("*******************************************************************************************************");
       System.out.println("                         la liste complet des clients                                                         ");
       System.out.println("*******************************************************************************************************");
        Compte.Liste_compte(TCptes,Client.cptes);
    }
     
    public static void Depot_Argent() {
        System.out.print("Taper le numero du compte depot: ");
        int numCpt = sc.nextInt();
        String format = "dd/MM/yy H:mm:ss"; 
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
        java.util.Date dat = new java.util.Date(); 
        boolean nemExist=false;
        for (Compte c : Compte.TCptes) {
            if (c.getNumero() == numCpt) {
                nemExist=true;
                System.out.println("Taper montant a deposer à ce numero");
                double montant = sc.nextDouble();
                 c.crediteCpt(montant);
                String sensOp ="Versement";
                Operation op = new Operation(sensOp, c.getNumero(),montant,formater.format( dat ));
                Operation.List_Op.add(op);
                System.out.println("----------------------------------------------------");
                System.out.println("Opération effectuée avec succée \n" + "Sens opération:"
                                   +sensOp+" \n"+"Numéro Compte:"+" "+String.format(" %03d", c.getNumero())+"\n"+
                        "Nouveau solde:"+" "+c.getSolde()+" euros\n"+ "Date:"+formater.format( dat ));
                System.out.println("----------------------------------------------------");
            } 
        } if(!nemExist) {
                System.out.println("Ce compte n'existe pas");
            }

    }
    
    public static void Recherche_comptes(){
        ArrayList<Compte> TCptes;ArrayList<Client> cptes;
        System.out.println("Entrer le numero de recherche ");
        Scanner sc1=new Scanner(System.in);
        int numCl = sc1.nextInt();
        boolean exist=false;
         System.out.println("****************************************************************************");
         System.out.println("ce numero d'identifiant est associé au(x) numero(s) de compte(s) suivant(s):");
        for (Compte c : Compte.TCptes) {
            if (c.getClient().getNumero() == numCl) {
                exist=true;
                System.out.println("- "+"Nom: "+c.getClient().getNom()+" "
                                   +"N° compte:"+String.format(" %03d", c.getNumero())+" "+"Solde="+
                                   " "+c.getSolde()+"euros");
         }
        }System.out.println("****************************************************************************");
           if(!exist) {
                System.out.println("Ce numero d'identifiant n'est associé aucun numero compte");
     }
    }
//consulter un comptes
    public static void consulter_compte(){
     System.out.println("Taper le numero du compte à consulter: ");
        int numCpt = sc.nextInt();
        boolean exist=false;
        for (Compte c : Compte.TCptes) {
            if (c.getNumero() == numCpt) {
                exist=true;
                System.out.println("ce compte appartient à:"+" Nom :"+c.getClient().getNom()+
                                   " "+"Solde="+" "+c.getSolde()+"Euros");
            }
        }
           if(!exist) {
                System.out.println("Ce numero n'appartient à personne");
            }
    }
    //méthode permettant de produire un rapport sur les comptes
    public static void retrait_Argent() {
        System.out.println("Taper le numero du compte à retrait: ");
        int numCpt = sc.nextInt();
        String format = "dd/MM/yy H:mm:ss"; 
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
        java.util.Date dat = new java.util.Date(); 
        boolean numExit=false;
            for (Compte c : Compte.TCptes) {
                 if (c.getNumero() == numCpt) {
                     numExit=true;
                System.out.println("Taper montant a retirer:");
                double montant = sc.nextDouble();
                c.retraitArgent(montant);
                String sensOp = "Retrait";
                Operation op = new Operation(sensOp, c.getNumero(),montant,formater.format( dat ));
                Operation.List_Op.add(op);
                System.out.println("----------------------------------------------------");
                System.out.println("Opération effectuée avec succée \n" + "Sens opération: 
                                   Retrait\n"+"Numéro Compte:"+" "+String.format(" %03d", c.getNumero())+"\n"+
                        "Nouveau solde:"+" "+c.getSolde()+" euros\n"+ "Date:"+formater.format( dat ));
                System.out.println("----------------------------------------------------");
            } 
        
          }
                if(!numExit){
                 System.out.println("Ce compte n'existe pas");
      }

    }
    public static void Produire_Rapport(){
         System.out.print("Le rapport d'activités:\n");
         System.out.print("--------------------------------------------------------------------\n");
        for(int i = 0; i < Operation.List_Op.size(); i++){
            System.out.println("+"+Operation.List_Op.get(i).getSensOp()+" de "+" "
                               +Operation.List_Op.get(i).getMntOp()+" "+"Euros"+" "+
                    "sur le compte:"+" "+Operation.List_Op.get(i).getNumCptOp()+
                               " date:"+""+Operation.List_Op.get(i).getDateOp());
            System.out.println("------------------------------------------------------------------");
        }
    }
     public static  void Calculer_Interet(){
          double interet=0;
          System.out.println("Taper la durée d'intérêt: ");
          int durée=sc.nextInt();
          System.out.println("----------------------------------------------------------------------");
          System.out.println("Calculer d'intérêt et la mise à jour effectué sur les numeros suivant:");
         for (Compte c : Compte.TCptes) {
           double ancien_solde=c.getSolde();
           interet = (c.getSolde() * durée* c.getTauxInteret())/(12*100);
           double Solde_Intérêt=c.getSolde() + interet;
           c.setSolde(Solde_Intérêt);
            System.out.println("Numero compte: "+String.format(" %03d", c.getNumero())+" "
                               +"Acien solde: "+ancien_solde+" "+"nouveau solde"+" "+c.getSolde());
         }
            System.out.println("----------------------------------------------------------------------");
   }

    
    
}
