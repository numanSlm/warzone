package project.app.warzone.Features;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.stringtemplate.v4.compiler.STParser.mapExpr_return;

import project.app.warzone.Model.GameEngine;
import project.app.warzone.Model.Map;



public class mapFeaturesTest {
//    Map map = new MapFeatures();
//    map.validateByNodes(a,b)
//    List List1=()
//    HashMap<Node,Boolean>  C = map.validateByNodes(a,b) 
//    assertNotNull(c);
    //constructor create
    public GameEngine gameEngine;
    public MapFeatures mapFeatures;
    public mapFeaturesTest(GameEngine gameEngine, MapFeatures mapFeatures){
        this.gameEngine= gameEngine;
        this.mapFeatures=mapFeatures;
    }

    @Before
    public void setUp(GameEngine gameEngine){
        String p_mapLocation=gameEngine.gameMap.getMapDirectory()+"\\"+Simpsons+".map";
        gameEngine.gameMap = mapFeatures.readMap(p_mapLocation);
        
    }

    //1. successfully adding players

    @Test
    public void TestValidateCorrectMap(GameEngine gameEngine){
        mapFeatures.validateEntireGraph(gameEngine)

        //get player list
        //assert statement to compare with returned number of players
        //or check if the returned list is null 
        //use assert null

        assertNotNull(gameEngine.//d_playersList);
    }

}
