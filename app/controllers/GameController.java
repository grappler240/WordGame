package controllers;

import models.Words;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Random;

public class GameController extends Controller
{
    private FormFactory formFactory;

    @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getStart()
    {
        return ok(views.html.start.render());
    }

    public Result getFirstStory()
    {
        Words words = new Words();
        words.setPlace1("Parking Lot");
        words.setAdjective1("fuzzy");
        words.setNoun1("Car");
        words.setNoun2("dumpster");
        words.setVerb1("noticed");
        words.setPlace2("the Asylum");

        return ok(views.html.story.render(words));
    }

    public Result getSecondStory()
    {
        Words words = new Words();
        words.setPlace1("Slaughter House");
        words.setAdjective1("dangerous");
        words.setNoun1("carcass");
        words.setNoun2("bathroom");
        words.setVerb1("freed");
        words.setPlace2("the graveyard");

        return ok(views.html.story.render(words));
    }

    public Result getThirdStory()
    {
        Words words = new Words();
        words.setPlace1("Coding Academy");
        words.setAdjective1("stinky");
        words.setNoun1("book bag");
        words.setNoun2("break room, talking to Mary");
        words.setVerb1("found");
        words.setPlace2("my chair and resume class");

        return ok(views.html.story.render(words));
    }

    public Result getRandomStory()
    {
        ArrayList<String> nouns = new ArrayList<>();
        nouns.add("credit");
        nouns.add("trick");
        nouns.add("pet");
        nouns.add("cook");
        nouns.add("mine");
        nouns.add("record");
        nouns.add("produce");
        nouns.add("rate");
        nouns.add("crook");
        nouns.add("snake");

        ArrayList<String> verbs = new ArrayList<>();
        verbs.add("humiliated");
        verbs.add("spoiled");
        verbs.add("dried");
        verbs.add("broke");
        verbs.add("preset");
        verbs.add("signified");
        verbs.add("told");
        verbs.add("arrested");
        verbs.add("ensured");
        verbs.add("vomitted");

        ArrayList<String> places = new ArrayList<>();
        places.add("house");
        places.add("prison");
        places.add("kitchen");
        places.add("cliff side");
        places.add("desert");
        places.add("pool");
        places.add("moon");
        places.add("rabbit hole");
        places.add("motherboard");
        places.add("work");

        ArrayList<String> adjectives = new ArrayList<>();
        adjectives.add ("complete");
        adjectives.add ("lacking");
        adjectives.add ("shiny");
        adjectives.add ("excellent");
        adjectives.add ("married");
        adjectives.add ("mute");
        adjectives.add ("maniacal");
        adjectives.add ("sick");
        adjectives.add ("murky");
        adjectives.add ("quarrelsome");

        Random random = new Random();

        int randomNounIndex = random.nextInt(nouns.size());
        String noun1 = nouns.get(randomNounIndex);

        randomNounIndex = random.nextInt(nouns.size());
        String noun2 = nouns.get(randomNounIndex);

        int randomVerbIndex = random.nextInt(verbs.size());
        String verb1 = verbs.get(randomVerbIndex);

        int randomPlaceIndex = random.nextInt(places.size());
        String place1 = places.get(randomPlaceIndex);

        randomPlaceIndex = random.nextInt(places.size());
        String place2 = places.get(randomPlaceIndex);

        int randomAdjectiveIndex = random.nextInt(adjectives.size());
        String adjective1 = adjectives.get(randomAdjectiveIndex);


        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setNoun2(noun2);
        words.setVerb1(verb1);
        words.setPlace2(place2);

        return ok(views.html.story.render(words));
    }
    public Result getMyOwnStory()
    {
        return ok(views.html.selectwords.render());
    }
    public Result postMyOwnStory()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String place1 = form.get("place1");
        String adjective1 = form.get("adjective1");
        String noun1 = form.get("noun1");
        String verb1 = form.get("verb1");
        String place2 = form.get("place2");
        String noun2 = form.get("noun2");

        Words words = new Words();
        words.setPlace1(place1);
        words.setAdjective1(adjective1);
        words.setNoun1(noun1);
        words.setVerb1(verb1);
        words.setPlace2(place2);
        words.setNoun2(noun2);

        return  ok(views.html.story.render(words));
    }

}
