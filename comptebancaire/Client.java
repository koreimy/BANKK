
package comptebancaire;

import java.util.ArrayList;
import java.util.Scanner;


/* constructeur client*/
public class Client {
    private int numero;
    private String nom;
    static ArrayList<Client> cptes= new ArrayList<Client>();
    
    /* creation de lq classe Client*/
    public  Client(int numero,String nom){
        this.numero = numero;
        this.nom = nom;
        //this.cptes = new ArrayList<Client>();
    }
    
    /*creation de la fonction qui renvoie le nom du client*/
    public String getNom(){
        return nom;
    }
    
    /* creation de la fonction qui envoie le numero du client*/
    public int getNumero(){
    return numero;
    }
    
    public ArrayList getlistcptes(){
        return cptes;
    }
    
    /* la fonction qui modifie le nom du client*/
    public void setNom(String n){
    nom=n;
    }
    
    /* la fonction qui ajoute un nouveau compte a un client*/
    public void addCompte(Client c){
    cptes.add(c);
    }
    
    public String Enregistrement_client(){
        String rep = "";
        if (cptes.isEmpty()) // vrai si la table des clients est vide
            return "client" + nom + "\t numero" + numero + "\n" + "pas de compte associe";
        for(int i=0; i<cptes.size(); i++)
            rep = rep +cptes.get(i).toString() + "\n";
        return "Client" + nom + "\t numero" + numero + "\n"+  cptes  + rep+"\n";    
    }
  
   
  public static void Liste_client(){
         for(int i = 0; i < cptes.size(); i++){
           System.out.println("Enregistrement N° " + (i+1) + " = " +
                   " Nom"+" "+cptes.get(i).getNom()+" " +
                  " Numero identifiant" +" " +cptes.get(i).getNumero() );
              }
           
     }
}
