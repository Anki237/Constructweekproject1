package apiProject;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class CryptocurrencyWallet {
	@Test(enabled = true)
	public void Registerauserandcreatewallet() {
		JSONObject js=new JSONObject();
		js.put("username", "Ankita");
		js.put("password", "securepassword");
		js.put("email", "ankita@example.com");
		given().body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/register").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void Logintheuserandgenerateasessiontoken() {
		JSONObject js=new JSONObject();
		js.put("username", "Ankita");
		js.put("password", "securepassword");
		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/login").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void Retrievethewalletbalance() {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/balance").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void Listallthetransactionsdonebytheuser() {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void Transfe5ETHtorecipient() {
		JSONObject js=new JSONObject();
		js.put("recipient_address", "0x1234567890ABCDEF");
		js.put("amount", 5.0);
		js.put("currency", "ETH");
		given().body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transactions").then().statusCode(200).log().all();
	}
	
	@Test(enabled = true)
	public void Calculatetransactionfeesandreturnestimatedcost() {
		JSONObject js=new JSONObject();
		js.put("amount", 2.5);
		js.put("currency", "BTC");
		js.put("recipient_address", "0x1234567890ABCDEF");
		given().body(js.toJSONString()).when().post("https://crypto-wallet-server.mock.beeceptor.com/api/v1/transaction_fee").then().statusCode(200).log().all();
	}
	@Test(enabled = true)
	public void Getanobjectwithallavailablecurrencyexchangerates() {
		given().get("https://crypto-wallet-server.mock.beeceptor.com/api/v1/exchange_rates").then().statusCode(200).log().all();
	}
	
}
