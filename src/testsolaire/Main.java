/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testsolaire;

import dao.DbConnection;
import dao.GenericDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import solaire.entity.BesoinSecteur;
import solaire.entity.Details;
import solaire.entity.SourceSolaire;
import solaire.etat.EtatSolaire;
import solaire.etat.Predict;

/**
 *
 * @author Mamisoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic her
        Connection con = null;
        try {
           con = DbConnection.connect();
            SourceSolaire source = GenericDao.findById(con, "SRC00001", new SourceSolaire());
            EtatSolaire etat = new EtatSolaire(source);
            Date date = Date.valueOf("2023-11-27");
            
//            int[] pointage = source.getSecteur(con).getPointageSecteur(con, date);
//            EtatSolaire etat2 = source.getEtatSolaire(con, 10, date,  49.3, pointage);
//            for ( Details details : etat2.getDetails()) {
//                System.out.println(
//                        "reserve batterie = " + details.getReserveBatterie()
//                        + " puissance delivree = " + details.getPuissanceDelivree()
//                        + " puissance delivree batterie = " + details.getPuissanceDelivreeBatterie()
//                        + " besoin = " + details.getBesoin()
//                        + " heure = " + details.getHeure()
//                        + " etat = " + details.getEtat()
//                );
//            System.out.println("----------------------------------------------------------------------------");
//            }
//            System.out.println("heure coupure = " + etat2.getHeureCoupure().toString());

//            Time time = Time.valueOf("15:00:00");
//            EtatSolaire besoin= etat.getEtatSolaireMoyenne(con, date, time);
////            GenericDao.save(con, besoin.getBesoin());
//            for ( Details details : besoin.getDetails()) {
//                System.out.println(
//                        "reserve batterie = " + details.getReserveBatterie()
//                        + " puissance delivree = " + details.getPuissanceDelivree()
//                        + " puissance delivree batterie = " + details.getPuissanceDelivreeBatterie()
//                        + " besoin = " + details.getBesoin()
//                        + " etat = " + details.getEtat()
//                        + " heure = " + details.getHeure()
//                );
//            System.out.println("----------------------------------------------------------------------------");
//            }
//            System.out.println("heure coupure = " + besoin.getHeureCoupure().toString());
//            System.out.println("besoin moyenne = " + besoin.getBesoin().getPuissanceMoyenne());
//            
            BesoinSecteur besSecteur = new BesoinSecteur();
            Predict predict = new Predict(Date.valueOf("2023-12-04"));
            predict.predict(con, 1);
            for (EtatSolaire state : predict.getEtat()) {
                System.out.println(state.getHeureCoupure());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
    
}