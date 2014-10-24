import com.ymd.demo.got.model.House;
import com.ymd.demo.got.service.WarService;
import com.ymd.demo.got.service.WarServiceImpl;
import com.ymd.demo.got.service.skill.SkillManagerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by yolandad on 6/19/14.
 */
public class IronThroneSoothesayer {


  public static void main(String[] args) throws IOException{

    //read the file
    byte[] jsonData = Files.readAllBytes(Paths.get("houses.json"));

    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();

    //convert json string to object
    List<House> houses = objectMapper.readValue(jsonData, objectMapper.getTypeFactory().constructCollectionType(List.class,House.class));

    System.out.println("House entering the battle:\n");
    for(House house : houses){
     System.out.println(house);
    }

    WarService warForTheThrone = new WarServiceImpl(SkillManagerFactory.getManager());
    House winner = warForTheThrone.battle(houses);
    System.out.println("\nWinning house:" + winner.toString());


  }

}
