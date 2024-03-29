import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class App {


    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";


        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("HEALTHY", Endangered.HEALTHY);
            model.put("OKAY", Endangered.OKAY);
            model.put("ILL", Endangered.ILL);
            model.put("NEWBORN", Endangered.NEWBORN);
            model.put("YOUNG", Endangered.YOUNG);
            model.put("ADULT", Endangered.ADULT);
            model.put("rangerName", request.session().attribute("rangerName"));
            model.put("template", "templates/animal-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/animals/new", (request, response) -> {
            String name = request.queryParams("name");
            boolean endangered = request.queryParamsValues("endangered") != null;
            if (endangered) {
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                Endangered endangeredAnimal = new Endangered(name, age, health);
                endangeredAnimal.save();
            } else {
                NonEndangered notEndangered = new NonEndangered(name);
                notEndangered.save();
            }
            response.redirect("/animals");
            return null;
        });

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("nonendangered", NonEndangered.all());
            model.put("endangered", Endangered.all());
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Endangered> animals = Endangered.all();
            model.put("animals", animals);
            model.put("template", "templates/sightings-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/sightings/new", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            Endangered animal = Endangered.find(Integer.parseInt(request.queryParams("animalid")));
            String location = request.queryParams("location");
            String rangername= request.queryParams("rangername");
            Sightings newSighting = new Sightings(location, rangername, animal.getId());
            newSighting.save();
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/sightings", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("sightings", Sightings.all());
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}