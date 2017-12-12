import methods.PlayerMethods;
import methods.PlayerMethodsJson;
import methods.PlayerMethodsSql;
import methods.PlayerMethodsXml;
import models.Player;
import models.Position;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        PlayerMethodsSql methods = new PlayerMethodsSql();
        Position position = new Position(1, "FR");
        Position position1 = new Position(2, "R");
        Position position2 = new Position(3, "LF");
        ArrayList<Position> list = new ArrayList<Position>();
        ArrayList<Position> list1 = new ArrayList<Position>();
        list.add(position);
        list1.add(position1);
        list1.add(position);
        Player player = new Player(1, "Toni","Kroos", LocalDate.parse("1987-02-02"), list);
        Player player1 = new Player(2, "Leo","Messi", LocalDate.parse("1987-02-02"), list1);
        methods.createPlayer(player);
        methods.createPlayer(player1);
//
//        System.out.println("Player by Position " + position1.getName());
//        for (Player p:methods.getPlayerList(position)) {
//            System.out.println("Name: " + p.getFirstName() + " Surname: " + p.getLastName() + " DateOfBirthday: " + p.getDateOfBirthday()
//            + " Position: " + p.getPosistions());
//        }
//
//        System.out.println("Player by year " + 30);
//        for (Player p:methods.getYearForPlayer(30)) {
//            System.out.println("Name: " + p.getFirstName() + " Surname: " + p.getLastName() + " DateOfBirthday: " + p.getDateOfBirthday()
//                    + " Position: " + p.getPosistions());
//        }
    }
}

