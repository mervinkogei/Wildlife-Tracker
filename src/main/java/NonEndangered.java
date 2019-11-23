import java.util.List;
import org.sql2o.*;

import static spark.route.HttpMethod.connect;

public class NonEndangered extends Animals{
    private NonEndangered(String name){
        this.name = name;
        endangered = false;
    }
    public static List<NonEndangered> all(){
        String sql = "SELECT * FROM animals WHERE endangered = false";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(NonEndangered.class);
            }
    }
    public static NonEndangered find(int id){
       try (Connection con = DB.sql2o.open()){
           String sql = "SELECT * FROM animals WHERE id = :id;";
           NonEndangered animal = con.createQuery(sql)
                   .addParameter("id",id)
                   .throwOnMappingFailure(false)
                   .executeAndFetchFirst(NonEndangered.class);
           if (animal == null) {
               throw new IndexOutOfBoundsException("Sorry, this animal is not Available in our Park");
           }
           return animal;
       }
    }
}
