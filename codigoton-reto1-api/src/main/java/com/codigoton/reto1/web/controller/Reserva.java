package com.codigoton.reto1.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.util.ResourceUtils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
   public void singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {

       try {
           // Get the file and save it somewhere
           byte[] bytes = file.getBytes();
           Path path = Paths.get(uploadDirectory() + "/" + file.getOriginalFilename());
           Files.write(path, bytes);

           List<ReservaMesaRs> clients = reservaService.generarReserva(path);
           //return ResponseEntity.ok(clients);
           response.addHeader("content-type", "text/plain; charset=utf-8");
           response.setStatus(200);

           PrintWriter out = response.getWriter();
           clients.forEach(cli ->{
        	   out.println(cli.getName());
        	   if(cli.getEstado().equals("OK")) {
        		   out.println(cli.getClients().toString());
        	   }else {
        		   out.println(cli.getEstado());
        	   }
        	   
           });
       } catch (IOException e) {
           e.printStackTrace();
       }
       
       
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
