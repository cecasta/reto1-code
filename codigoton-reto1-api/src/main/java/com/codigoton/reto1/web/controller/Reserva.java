package com.codigoton.reto1.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codigoton.reto1.db.entities.Client;
import com.codigoton.reto1.db.entities.ClientGroup;
import com.codigoton.reto1.db.repository.ClientRepository;
import com.codigoton.reto1.dto.BalanceCuentasClient;
import com.codigoton.reto1.dto.ReservaMesaRs;
import com.codigoton.reto1.service.ReservaService;

@RestController
@RequestMapping("/api")
public class Reserva {
	
	
	@Autowired
	private ReservaService reservaService;

    @RequestMapping(value = "/generarReserva", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String displayForm() {

        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
                "<body>\n" + "<form method=\"POST\" action=\"/api/uploadFile\" enctype=\"multipart/form-data\">\n" 
        		+ "<table><tr><td>Select a file to upload</td><td><input type=\"file\" name=\"file\" /></td></tr>"
                + "<tr><td><input type=\"submit\" value=\"Submit\" /></td></tr>"
        		+ "</table></form>"
                + "</body>\n" + "</html>";
    }

   
    @PostMapping("/uploadFile")
   public ResponseEntity<List<ReservaMesaRs>> singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

       try {
           // Get the file and save it somewhere
           byte[] bytes = file.getBytes();
           Path path = Paths.get(uploadDirectory() + "/" + file.getOriginalFilename());
           Files.write(path, bytes);

           List<ReservaMesaRs> clients = reservaService.generarReserva(path);
           return ResponseEntity.ok(clients);
       } catch (IOException e) {
           e.printStackTrace();
       }
	return null;

       
       
       
   }
    
	
	

	
    private String uploadDirectory() throws FileNotFoundException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());

        File upload = new File(path.getAbsolutePath(),"static/upload/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());

        return upload.getAbsolutePath();
    }
	

}
