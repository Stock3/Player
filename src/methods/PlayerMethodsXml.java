package methods;

import models.Player;
import models.Position;

import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerMethodsXml{
        private static List<Player> playerList;
        private static GenericMethodsXml<Player> playerGenericMethodsXml;

        //конструктор без параметрів
        public PlayerMethodsXml(){
            playerList = new ArrayList<Player>();
            playerGenericMethodsXml = new GenericMethodsXml<Player>(new File("player.xml"));
        }

        public void createPlayer(Player player){
            playerList.add(player);
            try {
                playerGenericMethodsXml.serialize(playerList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //метод який поверне список гравців по заданій позиції
        public List<Player> getPlayerList(Position position){
            try {
                playerList = playerGenericMethodsXml.deserialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return playerList.stream().filter((p)->p.getPosistions().contains(position)).collect(Collectors.toCollection(ArrayList::new));
        }

        public List<Player> getYearForPlayer(int year){
            try {
                playerList = playerGenericMethodsXml.deserialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return playerList.stream().filter((p)->(Year.now().getValue()-p.getDateOfBirthday().getYear())==year)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
}
