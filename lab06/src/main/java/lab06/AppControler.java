package lab06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControler {
    private AppService appService;

    @Autowired
    public AppService(AppService appService){this.appService=appService};
}
