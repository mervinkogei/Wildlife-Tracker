import org.sql2o.*;

import java.util.List;

public class Animals {
    private int id;
    private String name;

    public Animals (int id, String name){
        this.id= id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        } else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName()) &&
                    this.getName().equals(newAnimals.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO Animals (id, name) VALUES (:id, :name)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("1", this.id)
                    .executeUpdate();
        }
    }
    public static List<Animals> all() {
        String sql = "SELECT * FROM persons";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }
}
