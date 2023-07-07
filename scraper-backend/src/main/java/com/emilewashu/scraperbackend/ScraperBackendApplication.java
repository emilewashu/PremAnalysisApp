package com.emilewashu.scraperbackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
@RequestMapping("/stats/data")
@CrossOrigin(origins = "http://localhost:3005")
public class ScraperBackendApplication {
    
	private final Scraper scraper;
    public ScraperBackendApplication(Scraper scraper) {
        this.scraper = scraper;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScraperBackendApplication.class, args);
    }

	@GetMapping
	public List<PlayerData> getPlayers()
	{
		return scraper.retrieveData();
	}

}



// public class ScraperBackendApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(ScraperBackendApplication.class, args);
// 	}

// 	@GetMapping("data")
//         public ResponseEntity<List<PlayerData>> getPlayerData() {
//             return new ResponseEntity<>(
//                 retrieve(),
//                 HttpStatus.OK
//             );
//         }


// }
