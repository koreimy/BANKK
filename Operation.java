/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptebancaire;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brahim
 */
public class Operation {

    private int numOp;
    private String libOp;
    private double mntOp;
    private String sensOp;
    private String dateOp;
    private int numCptOp;
  static ArrayList<Operation> List_Op = new ArrayList<Operation>();
    public static  Scanner sc = new Scanner(System.in);

        public Operation( String sensCptOp, int numCptOp, double mntOp, String dateOp){
        this.sensOp = sensCptOp;
        this.dateOp = dateOp;
        this.numCptOp = numCptOp;
        this.mntOp = mntOp;
    }
    // la fonction qui renvoie le numero de l'operation effectuée
    public int getNumOp() {
        return numOp;
    }

    //la fonction qui renvoie le type de l'operation()
    public String getLibOp() {
        return libOp;
    }

    // la fonction qui renvoie le montant de l'operation
    public double getMntOp() {
        return mntOp;
    }

    //la fonction qui renvoie le sens de l'operation
    public String getSensOp() {
        return sensOp;
    }

    //la fonction qui renvoie la date de l'operation
    public String getDateOp() {
        return dateOp;
    }

    //la fonction qui renvoie le numero du compte sur laquelle l'operation a eu lieu
    public long getNumCptOp() {
        return numCptOp;
    }

    //la fonction qui modifie le montant de l'opertion
    public void setmntOp(double mnt) {
        this.mntOp = mnt;
    }

    //la fonction qui permet de modifier le sens de l'operation
    public void setSensOp(String sensop) {
        this.sensOp = sensop;
    }

    //la fonction qui permet de modifier la date de l'operation
    public void setDateOp(String dateop) {
        this.dateOp = dateop;
    }

    //la fonction qui permet de modifier le numero de compte sur laquelle l'operation s'effectue
    public void setNumCptOp(int numcptOp) {
        this.numCptOp = numcptOp;
    }

    //la fonction qui oermet de modifier le libelle de l'operation
    public void setLibOp(String libop) {
        this.libOp = libop;
    }

    public void setNumOp(int numop) {
        this.numOp = numop;
    }

    public String toString() {
        String rep="";
        //if((Client != null)&&Client.cptes.size()>0)
        for(int i = 0; i < Compte.TCptes.size(); i++){
        System.out.println("Enregistrement " + i + " = " + Compte.TCptes.get(i).getNumero() + " " + Compte.TCptes.get(i).getSolde());
        //rep = numOp + "| " + libOp + "| " + mntOp + "| " + sensOp + "| " + dateOp + "|" + numCptOp;
        }
        return rep;
    }

}
