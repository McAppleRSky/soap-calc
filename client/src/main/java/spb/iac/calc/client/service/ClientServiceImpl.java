package spb.iac.calc.client.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ClientServiceImpl implements ClientService {

    private final String REQUEST_TEMPLATE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gs=\"iac.spb/calc/schema\"><soapenv:Header/><soapenv:Body><gs:calcRequest><gs:variables><gs:a>:a_value</gs:a><gs:b>:b_value</gs:b><gs:c>:c_value</gs:c></gs:variables></gs:calcRequest></soapenv:Body></soapenv:Envelope>";
    private final String POSTS_API_URL = "http://localhost:8080/ws";
    private final int PRETTY_PRINT_INDENT_FACTOR = 4;

    @Override
    public String request(int a, int b, int c) {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .POST(
                        HttpRequest
                                .BodyPublishers
                                .ofString(REQUEST_TEMPLATE
                                        .replaceFirst(":a_value", String.valueOf(a))
                                        .replaceFirst(":b_value", String.valueOf(b))
                                        .replaceFirst(":c_value", String.valueOf(c))))
                .header("content-type", "text/xml")
                .uri(URI.create(POSTS_API_URL))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
        } catch (java.net.ConnectException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject xmlJSONObj = XML.toJSONObject(response.body());
        return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
    }

}
