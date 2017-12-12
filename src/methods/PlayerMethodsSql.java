package methods;

import models.Player;
import models.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerMethodsSql {
    private GenericProviderSql<Player> genericProvider;


    public PlayerMethodsSql(){
        try {
            genericProvider = new GenericProviderSql<Player>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //перетворення результату виконання запиту в ArrayList
    private static ArrayList<Player> mappingListResult(ResultSet result) throws SQLException {
        ArrayList<Player> list = new ArrayList<Player>();
        Player player = new Player();
        try {
            while (result.next()) {
                player.setId(result.getInt(1));
                player.setFirstName(result.getString(2));
                player.setLastName(result.getString(3));
                player.setDateOfBirthday(LocalDate.parse(result.getString(4)));
                player.setPosistions((List<Position>) result.getArray(5));
                list.add(new Player(player.getId(), player.getFirstName(), player.getLastName(), player.getDateOfBirthday(), player.getPosistions()));
            }
        } finally {
            if (result != null) {
                result.close();
            }
        }
        return list;
    }

    public void createPlayer(Player player){
        try {
            genericProvider.execute("call CreatePlayer", new Object[]{player.getFirstName(), player.getLastName(), player.getDateOfBirthday(), player.getPosistions().stream().findFirst().get().getId()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //метод який поверне список гравців по заданій позиції
    public List<Player> getPlayerList(Position position) {
        List<Player> playerList = new ArrayList<Player>();
        try {
            playerList = mappingListResult(genericProvider.getList("call GetPlayerListByPosition", new Object[]{position.getId()}));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    public ArrayList<Player> getYearForPlayer(int year){
        ArrayList<Player> playerList = new ArrayList<Player>();
        try {
            playerList = mappingListResult(genericProvider.getList("call GetYearForPlayer", new Object[]{year}));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }
}
