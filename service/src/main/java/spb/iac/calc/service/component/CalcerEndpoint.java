package spb.iac.calc.service.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import spb.iac.calc.schema.CalcRequest;
import spb.iac.calc.schema.CalcResponse;

@Endpoint
public class CalcerEndpoint {

    private static final String NAMESPACE_URI = "iac.spb/calc/schema";

    private Calcer calcer;

    @Autowired
    public CalcerEndpoint(Calcer calcer) {
        this.calcer = calcer;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcRequest")
    @ResponsePayload
    public CalcResponse calc(@RequestPayload CalcRequest request) {
        CalcResponse response = new CalcResponse();
        response.setResult(calcer.calc(request.getVariables()));
        return response;
    }

}
