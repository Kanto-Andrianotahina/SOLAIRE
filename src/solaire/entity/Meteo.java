package solaire.entity;

import annotation.Column;
import annotation.PrimaryKey;
import annotation.Table;
import dao.GenericDao;
import java.sql.Date;
import java.sql.Time;
import java.sql.Connection;
import java.util.List;


@Table(name = "meteo")
public class Meteo{
    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    Integer id;
    @Column(name = "luminosite")
    Double luminosite;
    @Column(name = "heure_fin")
    Time heureFin;
    @Column(name = "date_meteo")
    Date dateMeteo;
    @Column(name = "heure_debut")
    Time heureDebut;

    //SETTERS AND GETTERS
        
    public Double getLuminosite(){
        return this.luminosite;
    }
    public void setLuminosite(Double luminosite){
        this.luminosite = luminosite;
    }
    public Time getHeureFin(){
        return this.heureFin;
    }
    public void setHeureFin(Time heureFin){
        this.heureFin = heureFin;
    }
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Date getDateMeteo(){
        return this.dateMeteo;
    }
    public void setDateMeteo(Date dateMeteo){
        this.dateMeteo = dateMeteo;
    }
    public Time getHeureDebut(){
        return this.heureDebut;
    }
    public void setHeureDebut(Time heureDebut){
        this.heureDebut = heureDebut;
    }

    //CONSTRUCTORS

    public Meteo(){}
    public Meteo(Double luminosite, Time heureFin, Integer id, Date dateMeteo, Time heureDebut){
        setLuminosite(luminosite);
        setHeureFin(heureFin);
        setId(id);
        setDateMeteo(dateMeteo);
        setHeureDebut(heureDebut);
    }
    
    //METHODS 
    public List<Meteo> getMeteoDu(Connection con, Date date)throws Exception{
        String condition = "date_meteo = '" + date.toString() + "' ORDER BY heure_debut,id";
        return GenericDao.findWhere(con, condition, new Meteo());
    }

}