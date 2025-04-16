import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import com.testassured.PropostaRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


@Epic("Sisloc API Tests")
@Feature("Proposta Query API")
public class PropostaApiTest {
    private static final String BASE_URI = "https://app-dev.sisloc.com.br/WUSR200ExposeAPIService/rest/ForcaDeVendas";
    private static final String AUTH_TOKEN = "7150ef38-4e78-4df6-8452-c8c6dac6c658"; 
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.registerParser("text/plain", Parser.JSON);
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void getProposta(){
        PropostaRequest propostaRequest = new PropostaRequest();
        propostaRequest.setDataInicio("2025-04-01");
        propostaRequest.setDataFim("2025-04-30");
        given()
            .queryParam("Authorization", AUTH_TOKEN)
            .queryParam("InsertionDateStart", propostaRequest.getDataInicio())
            .queryParam("InsertionDateFinish", propostaRequest.getDataFim())
        .when()
            .get("/Proposta/Query")
        .then()
            .assertThat()
            .log().body()
            .statusCode(200);
    }

}