package com.example.tuterdust.animenotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuterdust on 31/5/2560.
 */

public class MockUpAnimes implements AnimeRepository{

    private List<Anime> animes =new ArrayList<>();
    private static MockUpAnimes instance;

    private MockUpAnimes() {
        setUpAnimes();
    }

    public static  MockUpAnimes getInstance() {
        if(instance == null)
            instance = new MockUpAnimes();
        return instance;
    }

    public void setUpAnimes() {
        String name, director, description, day, time, url;
        ArrayList<String> cvs = new ArrayList<>();

        name = "Rokudenashi Majutsu Koushi to Akashic Records";
        director = "Kazuto, Minato";
        description = "Sistine attends a magical academy to hone her skills in the magical arts, hoping to solve the mystery of the enigmatic Sky Castle. " +
                "After the retirement of her favorite teacher, the replacement, Glenn, turns out to be a tardy, lazy, and seemingly incompetent bastard of an instructor. " +
                "How is it that Glenn was hand-picked by the best magician in the academy?!";
        day = "Tuesday";
        time = "18.30";
        url = "https://i.ytimg.com/vi/Yd167JFfj7o/maxresdefault.jpg";
        cvs.clear();
        cvs.add("Saito, Soma");
        cvs.add("Fujita, Akane");
        cvs.add("Miyamoto, Yume");
        Anime a1 = new Anime(name, director, description, cvs, day, time, url);

        name = "Shingeki no Kyojin Season 2";
        director = "Araki, Tetsurou";
        description  = "Second season of Shingeki no Kyojin.";
        day = "Saturday";
        time = "20.00";
        url="https://xtremepyrosonic.files.wordpress.com/2016/07/cmb-jlgueaesm3u.jpg?w=1200";
        cvs.clear();
        cvs.add("Ishikawa, Yui");
        cvs.add("Kaji, Yuki");
        Anime a2 = new Anime(name, director, description, cvs, day, time, url);

        name = "Eromanga-sensei";
        director = "Takeshita, Ryouhei";
        description  = "The \"new sibling romantic comedy\" revolves around Masamune Izumi, " +
                "a light novel author in high school. Masamune's little sister is Sagiri, a shut-in girl who hasn't left her room for an entire year. She even forces her brother to make and bring her meals when she stomps the floor. " +
                "Masamune wants his sister to leave her room, because the two of them are each other's only family.";
        day = "Sunday";
        time = "22.30";
        url="http://www.animenewsnetwork.com/thumbnails/fit600x1000/cms/episode-review/114839/eromangabanner.jpg";
        cvs.clear();
        cvs.add("Fujita, Akane");
        cvs.add("Matsuoka, Yoshitsugu");
        Anime a3 = new Anime(name, director, description, cvs, day, time, url);

        name = "Re:Creators";
        director = "Aoki, Ei";
        description  = "Humans have designed countless worlds—each one born from the unique imagination of its creator. " +
                "Souta Mizushino is a high school student who aspires to be such a creator by writing and illustrating his own light novel. One day, while watching anime for inspiration, he is briefly transported into a fierce fight scene. When he returns to the real world, " +
                "he realizes something is amiss: the anime's headstrong heroine, Celestia Yupitilia, has somehow returned with him.";
        day = "Saturday";
        time = "21.30";
        url="http://www.downvids.net/video/bestimages/img-recreators-announcement-pv-695.jpg";
        cvs.clear();
        cvs.add("Komatsu, Mikako");
        cvs.add("Minase, Inori");
        Anime a4 = new Anime(name, director, description, cvs, day, time, url);

        name = "Sakura Quest";
        director = "Masui, Souichi";
        description  = "In the wake of a nationwide movement during the Bubble economy period, a small town in the countryside has revived its \"mini-nation\" tourism program; hiring five girls as travel ambassadors. " +
                "The series will follow a year's time of the five girls as they work in the tourism agency of a small failing town in an effort to reinvigorate it.";
        day = "Thursday";
        time = "22.00";
        url="https://images8.alphacoders.com/778/thumb-350-778123.png";
        cvs.clear();
        cvs.add("Nanase, Ayaka");
        cvs.add("Ueda, Reina");
        cvs.add("Komatsu, Mikako");
        Anime a5 = new Anime(name, director, description, cvs, day, time, url);

        name = "Saenai Heroine no Sodatekata";
        director = "Kamei, Kanta";
        description  = "Second season of Saenai Heroine no Sodatekata.";
        day = "Friday";
        time = "22.55";
        url="https://i1.wp.com/www.otakutale.com/wp-content/uploads/2017/02/Saenai-Heroine-no-Sodatekata-flat-Visual.jpg?resize=868%2C579";
        cvs.clear();
        cvs.add("Yasuno, Kiyono");
        cvs.add("Kayano, Ai");
        Anime a6 = new Anime(name, director, description, cvs, day, time, url);

        name = "Frame Arms Girl";
        director = "Kawaguchi, Keiichirou";
        description  = "The story begins when Ao opens a package that arrives at her doorstep. " +
                "Inside the package is Gourai, a Frame Arms Girl: a small robot capable of independent movement. Gourai is a newly-developed prototype: a Frame Arms Girl equipped with an \"Artificial Self,\" an advanced AI that gives her a personality. Ao is the only one that has activated her. " +
                "Gourai begins to gather both battle data and emotions, starting a day-to-day life with Ao, who knows nothing about Frame Arms Girls.";
        day = "Tuesday";
        time = "23.05";
        url="https://i.ytimg.com/vi/8oVhZc26u7U/maxresdefault.jpg";
        cvs.clear();
        cvs.add("Hikasa, Yoko");
        cvs.add("Nagae, Rika");
        cvs.add("Ayase, Yuu");
        Anime a7 = new Anime(name, director, description, cvs, day, time, url);

        animes.add(a1);
        animes.add(a2);
        animes.add(a3);
        animes.add(a4);
        animes.add(a5);
        animes.add(a6);
        animes.add(a7);

    }

    @Override
    public List<Anime> getAnimes() {
        return animes;
    }
}
