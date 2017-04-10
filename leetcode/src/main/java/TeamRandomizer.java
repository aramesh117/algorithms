import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TeamRandomizer {
    public static void main(String[] args) {
        Random random = new Random(1);
        String[] players = {
                "Emilyn Smith",
                "Anoop Dixith",
                "Jean Paul Fontneau",
                "Cory Hershey",
                "Anatoly Katsev",
                "Kirill Kondratiev",
                "Rui Li",
                "Kyna Lim",
                "Fleur Nittolo",
                "Chris Roach",
                "Claudia Salhab",
                "Zhong Liu Mike Fan",
                "Saiguang Che",
                "Spencer Wise",
                "Eric \"The Power\" Owusu-Ansah",
                "Hui Zhang",
                "Jonathan Indig",
                "Jim Chiang",
                "Dylan Armajani",
                "Tim \"Julio Geordio\" Arkley",
                "Olivier Wellmann",
                "Jinyu Zhang",
                "David Wasicki",
                "Neil \"Northern Massive\" Alexander",
                "Ian \"2 Left Feet\" Franklyn",
                "Meredith Leu",
                "Haijie Wu",
                "Naytram Deonarain",
                "Jose \"Murinio\" Jesus",
                "Chase Botelho",
                "Deepti Mande",
                "Karan Luniya",
                "Chris Creed",
                "Tony \"The Whippet\" Dolan",
                "Richard Wray",
                "Anilesh Shrivastava",
                "Shrikant Kakani",
                "Thomas Maxwell",
                "Ernesto \"The Magic\" Johnson",
                "Jibin Zhan",
                "Haoshuang Ji",
                "Aniruddha Vyawahare",
                "John Ferrandino",
                "David \"The Bulldog\" Maclarty",
                "Alexey Kobrinskii",
                "Jose Solorio",
                "Aaditya Ramesh",
                "Tim Rubey",
                "Lucas \"Show me the Protein\" Eaton",
                "Kerry Hew: \"The 2-second Tornado\"",
                "Paras Wadehra #23",
                "Brian Pfaff",
                "Kimberly Mena #7",
                "Pavan \"The Spice\" Marneni",
                "Robert Chafino",
                "Keith Zubchevich"

        };
        List<String> playersList = Arrays.asList(players);
        Collections.shuffle(Arrays.asList(players), random);
//        System.out.println(playersList);
        List<List<String>> teams = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            teams.add(playersList.subList(7 * i, Math.min(7 * (i + 1), playersList.size())));
        }

        int i = 1;
        for(List<String> team: teams) {
            System.out.println(String.format("Team %d: %s", i, team));
            i ++;
        }
    }
}
