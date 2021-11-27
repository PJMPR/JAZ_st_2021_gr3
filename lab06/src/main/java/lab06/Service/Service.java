package Lab06.Service;

import Lab06.Credit.Credit;
import Lab06.Exception.CreditNotFoundException;
import Lab06.FilesBuilders.CSVBuilder;
import Lab06.Repository.CreditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class Service {
    private CreditRepository repository;

    @Autowired
    public Service(CreditRepository creditRepository) {
        this.repository = creditRepository;
    }


    public void evaluateCredit(Credit credit) {

        credit.doTheMath();
        repository.save(credit);

        System.out.println(credit);

    }

    public String getTimeTableJson(Integer id) throws CreditNotFoundException, JsonProcessingException {
        Credit creditFromDB =  repository.findById(id).orElseThrow(CreditNotFoundException::new);
        return new ObjectMapper().writeValueAsString(creditFromDB);
    }


    public void getTimeTableCVS(Integer id) throws CreditNotFoundException, JsonProcessingException, FileNotFoundException {
        String json = getTimeTableJson(id);
        new CSVBuilder(json).buildFile();
    }
}
