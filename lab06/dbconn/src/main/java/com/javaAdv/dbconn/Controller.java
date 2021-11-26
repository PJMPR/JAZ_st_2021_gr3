package com.javaAdv.dbconn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/credit")
public class Controller {
    @Autowired
    private  ParamInterface paramInterface;
    @Autowired
    private HarmonoInterface harmonoInterface;
    @PostMapping("/params")
    public Params save(@RequestBody Params params){
        return paramInterface.save(params);
    }
    @PostMapping("/calculation")
    public Integer calculate(@RequestBody Params params){
        int count = 0;

        for (int i = 0; i < params.getInstallment_count(); i++) {
            Harmonogram harmonogram = new Harmonogram();
            harmonogram.setNum(i);
            harmonogram.setAmount(params.getAmount());
            harmonogram.setInterest(params.getPercentage()*harmonogram.getAmount());
            harmonogram.setFixed_rate(params.getFixedRate());
            //uproszczony sposob oblicznia rat
            harmonogram.setCapital(harmonogram.getAmount()-(harmonogram.getNum()*harmonogram.getInterest()));
            harmonogram.setCapitalToPay(harmonogram.getAmount()-((harmonogram.getNum()+1)*harmonogram.getInterest()));
            harmonoInterface.save(harmonogram);
            count++;
        }
        return count;
    }
    @GetMapping("/timetable/{id}")
    public List<Harmonogram> getTable(){
    return harmonoInterface.findAll();
    }


}
