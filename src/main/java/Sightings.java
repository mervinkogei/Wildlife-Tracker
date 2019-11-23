import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

public class Sightings {
    private int id;
    private String location;
    private String rangerName;
    private int animalId;
    private Timestamp spotted;

    public Sightings (String location, String rangerName,int animalId){
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
        this.animalId = animalId;
    }

    public String getLocation(){
        return location;
    }
    public String getRangerName(){
        return rangerName;
    }
    public int getId(){
        return id;
    }
    public int getAnimalId(){
        return animalId;
    }
    public String getFormattedDate(){
        return DateFormat.getDateInstance().format(spotted);
    }
    @Override
    public boolean equals (Object anotherSightings){
        if(!(anotherSightings instanceof Sightings)){
            return false;
        }
        else {
            Sightings newSighting = (Sightings) anotherSightings;
            return this.getId() == newSighting.getId() &&
                    this.getLocation().equals(newSighting.getLocation()) &&
                    this.getRangerName().equals(newSighting.getRangerName());
        }
    }
    public static List<Sightings>all(){
        String sql = "SELECT * FROM sightings;";
        try(Connection con =DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }
    public void save(){
        try (Connection con = DB.sql2o.open()){
          String sql = "INSERT INTO sightings(location,rangerName,spotted,animalId) VALUES (:location, :rangerName, now(),:animalId";
          this.id = (int) con.createQuery(sql,true)
                  .addParameter("location",this.location)
                  .addParameter("rangerName",this.rangerName)
                  .addParameter("animalId",this.animalId)
                  .executeUpdate()
                  .getKey();
        }
    }
    public static Sightings find(int id){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE id=:id";
            Sightings sightings = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }
}
