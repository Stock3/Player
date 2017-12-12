package methods;

import models.Player;
import models.Position;

import java.time.Year;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerMethods {

    private static ArrayList<Player> playerList;

    //конструктор без параметрів
    public PlayerMethods(){
        playerList = new ArrayList<Player>();
    }

    public void createPlayer(Player player){
        playerList.add(player);
    }

    //метод який поверне список гравців по заданій позиції
    public ArrayList<Player> getPlayerList(Position position){
        return playerList.stream().filter((p)->p.getPosistions().contains(position)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Player> getYearForPlayer(int year){
        return playerList.stream().filter((p)->(Year.now().getValue()-p.getDateOfBirthday().getYear())==year)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    }


