package com.academyproject.championsacademyleague.accesingdatamysql.config;

import com.academyproject.championsacademyleague.services.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    @RequestMapping("TestMe")
    public void testMe() throws FileNotFoundException {
        configService.iCanReadProperties();
    }

    @PostMapping(path="saveConfigFile")
    public String saveConfigFile(@RequestParam("IP") String IP, @RequestParam("port") String port,@RequestParam("DBip") String DBip, @RequestParam("DBport") String DBport, @RequestParam("DBAdmin") String DBAdmin, @RequestParam("DBPassword") String DBPassword){
        try {
            configService.saveConfigFile(IP, port, DBip, DBport, DBAdmin, DBPassword);
            return "Success";
        }catch(IOException e){
            return "saveConfigFile Error: The save of the file was not successful";
        }
    }
}
