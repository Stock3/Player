package methods;

import models.Player;
import models.Position;

import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerMethodsJson {
    private static List<Player> playerList;
    private static GenericMethodsJson<Player> genericMethodsJson;

    //конструктор без параметрів
    public PlayerMethodsJson(){
        playerList = new ArrayList<Player>();
        genericMethodsJson = new GenericMethodsJson<Player>(new File("player.json"));
    }

    public void createPlayer(Player player){
        playerList.add(player);
        try {
            genericMethodsJson.serialize(playerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод який поверне список гравців по заданій позиції
    public List<Player> getPlayerList(Position position){
        try {
            playerList = genericMethodsJson.deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList.stream().filter((p)->p.getPosistions().contains(position)).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Player> getYearForPlayer(int year){
        try {
            playerList = genericMethodsJson.deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerList.stream().filter((p)->(Year.now().getValue()-p.getDateOfBirthday().getYear())==year)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
