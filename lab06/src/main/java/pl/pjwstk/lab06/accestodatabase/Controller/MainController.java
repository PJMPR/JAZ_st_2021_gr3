package pl.pjwstk.lab06.accestodatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.lab06.accestodatabase.Calculations.Calculator;
import pl.pjwstk.lab06.accestodatabase.Files.Csv;
import pl.pjwstk.lab06.accestodatabase.Files.Pdf;
import pl.pjwstk.lab06.accestodatabase.Repositories.InstalmentRepository;
import pl.pjwstk.lab06.accestodatabase.Timetable.Credit;
import pl.pjwstk.lab06.accestodatabase.Timetable.Installment;
import pl.pjwstk.lab06.accestodatabase.Repositories.CreditRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    CreditRepository creditRepository;
    InstalmentRepository instalmentRepository;
    Pdf pdfFile;
    Csv csvFile;

    @Autowired
    public MainController(CreditRepository creditRepository, InstalmentRepository installment, Pdf pdfFile, Csv csvFile){
        this.creditRepository = creditRepository;
        this.instalmentRepository = installment;
        this.pdfFile = pdfFile;
        this.csvFile = csvFile;
    }


    @PostMapping(path = "credit/calculations")
    public int calculations(@RequestBody Credit credit){
        creditRepository.save(credit);
        List<Installment> installmentList = new Calculator().calculate(credit);
        System.out.println("jasdjasbdihsa");
        installmentList.forEach(installment -> instalmentRepository.save(installment));
        return credit.getId();
    }
    @GetMapping(value = "credit/credit",params = "id")
    public Optional<Credit> getCredit(@RequestParam Integer id){
        return creditRepository.findById(id);
    }

    @GetMapping(value = "/credit/credit",params = {"id","file"})
    public void getFile(HttpServletResponse response, @RequestParam Integer id, @RequestParam String file) throws IOException {
        switch (file) {
            case "pdf" -> Pdf.getFile(response,id,instalmentRepository);
            case "csv" -> Csv.getFile(response,id,instalmentRepository);
        }
    }
}