package com.academyproject.championsacademyleague.accesingdatamysql.config;

import com.academyproject.championsacademyleague.services.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "configuration")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping(path="loadConfig")
    public List<String> loadConfig(){
        return configService.loadConfig();
    }

    @GetMapping(path="loadDBCredentials")
    public List<String> loadDBCredentials(){
        return configService.loadBDConfig();
    }

    @PostMapping(path="saveConfigFile")
    public String saveConfigFile(@RequestParam("filePath") String filePath, @RequestParam("IP") String IP, @RequestParam("port") String port, @RequestParam("DBAdmin") String DBAdmin, @RequestParam("DBPassword") String DBPassword){
        configService.saveConfigFile(filePath, IP, port, DBAdmin, DBPassword);
        return "Vamos tentar";
    }
}
