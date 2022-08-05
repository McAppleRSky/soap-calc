package spb.iac.calc.service.component;

import org.springframework.stereotype.Component;
import spb.iac.calc.schema.Result;
import spb.iac.calc.schema.Variables;

import javax.annotation.PostConstruct;

@Component
public class Calcer {

    @PostConstruct
    public void initData() {
        System.out.println();
    }

    public Result calc(Variables variables) {
        Result result = new Result();
        result.setFormula("3x^2+4x+1=0");
        result.setD(0);
        result.setX1(0);
        result.setX2(0);
        return result;
    }

}
