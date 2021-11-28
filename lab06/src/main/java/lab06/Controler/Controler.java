package Lab06.Controler;

import Lab06.Credit.Credit;
import Lab06.Repository.CreditRepository;
import Lab06.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
public class Controler {
    private Service service;
    public CreditRepository creditRepository;

    @Autowired
    public Controler(Service service){
        this.service = service;
    }

    @GetMapping("/")
    public String defaultMapping(){
        return "Default";
    }

    @PostMapping(path="/credit/calculate")
    public ResponseEntity<Integer> addNewCredit(@RequestBody Credit creditData) {

        service.evaluateCredit(creditData);
        return new ResponseEntity<>(creditData.getId(), HttpStatus.OK);
    }


    @GetMapping("credit/timetable/{id}")
    public  ResponseEntity<String> getJsonTimeTable(@PathVariable Integer id) throws IOException, IllegalAccessException {

        String jSONTimeTable = service.getTimeTableJson(id);

        return new ResponseEntity<>(jSONTimeTable,HttpStatus.OK);
    }

    @GetMapping("credit/timetable/{id}&file=csv")
    public ResponseEntity<String> getCVS(@PathVariable Integer id) throws IOException, IllegalAccessException {
        service.getTimeTableCVS(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("credit/timetable/{id}&file=pdf")
    public ResponseEntity<String> getPdf(@PathVariable Integer id) throws IOException, IllegalAccessException {
        service.getTImeTablePDF(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
