package ru.gavryushkin.parser.bitmex;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.gavryushkin.parser.bitmex.model.Order;
import ru.gavryushkin.parser.bitmex.model.Position;
import ru.gavryushkin.parser.bitmex.model.User;

import java.util.Arrays;

public class Bitmex {

//    public static void main(String[] args) {
//        SpringApplication.run(Bitmex.class, args);
//        //getUser();
//        getPozition();
//    }

    private static RestTemplate restTemplate = new RestTemplate();
    private static String ApiKey = null;
    //private static String BASEPATH = "https://testnet.bitmex.com/api/v1";
    private static String BASEPATH="https://www.bitmex.com/api/v1";
//    private final static String ID = "v0_GfasE_fVwbOEX5_PtTiPC";
//    private final static String KEY = "6Z87UN9hJK-2jFnp-mgBlnznBPmOfHz7kKxvCb7t87MmjcBj";

    public static int getUser(String id, String key) {
        String method = "GET";
        String data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        String url = "/api/v1/user";
        try {
            ApiKey = Hex.hmacSha256(method + url + data, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", id);
        headers.set("api-signature", ApiKey);
        headers.set("api-expires", data);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                BASEPATH + "/user", HttpMethod.GET, entity, User.class);
        return responseEntity.getStatusCode().value();
    }

    public synchronized static String [] getPozition(String id, String key) {
        String method = "GET";
        String data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        String url = "/api/v1/position?symbol=XBTUSD";
        try {
            ApiKey = Hex.hmacSha256(method + url + data, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", id);
        headers.set("api-signature", ApiKey);
        headers.set("api-expires", data);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<Position[]> responseEntity = restTemplate.exchange(
                BASEPATH + "/position?symbol=XBTUSD", HttpMethod.GET, entity, Position[].class);
        System.out.println(responseEntity.getStatusCode());
        Arrays.asList(responseEntity.getBody()).forEach(System.out::println);
        if (responseEntity.getBody().length == 0) {
            System.out.println("Нет открытых позиций");
        }
        String []pozition={
                String.valueOf(responseEntity.getBody()[0].getCurrentQty()),
                String.valueOf(responseEntity.getBody()[0].getPrevClosePrice())
        };
        return pozition;
    }

    public synchronized static void createOrderBuy(String id, String key, String quantity) {
        String method = "POST";
        String data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        String url = "/api/v1/order";
        String body = "{\"symbol\":\"XBTUSD\",\"orderQty\":"+quantity+"}";
        //String bodyUrl = "{symbol:XBTUSD,orderQty:" + quantity + "}";
        try {
            ApiKey = Hex.hmacSha256(method + url + data + body, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", id);
        headers.set("api-signature", ApiKey);
        headers.set("api-expires", data);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity(body, headers);

        ResponseEntity<Order> responseEntity = restTemplate.exchange(
                BASEPATH + "/order", HttpMethod.POST, entity, Order.class);
        System.out.println(responseEntity.getStatusCode());
    }

    public synchronized static void createOrderSell(String id, String key, String quantity) {
        String method = "POST";
        String data = String.valueOf(System.currentTimeMillis() / 1000 + 3600);
        String url = "/api/v1/order";
        String body = "{\"symbol\":\"XBTUSD\",\"side\":\"Sell\",\"orderQty\":"+quantity+"}";
        //String bodyUrl = "{symbol:XBTUSD,orderQty:" + quantity + "}";
        try {
            ApiKey = Hex.hmacSha256(method + url + data + body, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", id);
        headers.set("api-signature", ApiKey);
        headers.set("api-expires", data);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity(body, headers);

        ResponseEntity<Order> responseEntity = restTemplate.exchange(
                BASEPATH + "/order", HttpMethod.POST, entity, Order.class);
        System.out.println(responseEntity.getStatusCode());
    }
}


