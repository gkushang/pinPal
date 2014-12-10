package com.pinpal.controller;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;

import com.pinpal.page.PhotoPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
public class PhotoPageController
{

    private final PinPalService _pinPalService;

    @Autowired
    public PhotoPageController
            (
                    PinPalService pinPalService
            )
    {

        _pinPalService = pinPalService;
    }

    @RequestMapping(value = {"/photo/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {

        html.render(new PhotoPage(_pinPalService));

    }


//    @ResponseBody
//    protected void uploadPhoto
//            (
//                    HttpServletRequest request
//
//            ) throws IOException
//    {
////        File convFile = new File(multipart.getOriginalFilename());
////        multipart.transferTo(convFile);
//        System.out.println("File Name: ");
//
//    }

    @RequestMapping(value = {"/upload-photo/"}, method = RequestMethod.POST)
    public
    @ResponseBody
    void handleFileUpload
            (
                    MultipartHttpServletRequest request, HttpServletResponse response
            )
    {
        System.out.println("\n\nworked\n\n");

        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() + " uploaded!");

        UploadedFile ufile = new UploadedFile();

        try
        {
            //just temporary save file info into ufile

            ufile.length = mpf.getBytes().length;
            ufile.bytes = mpf.getBytes();
            ufile.type = mpf.getContentType();
            ufile.name = mpf.getOriginalFilename();

            _pinPalService.setImageBytes(ufile.bytes);

        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //2. send it back to the client as <img> that calls get method
        //we are using getTimeInMillis to avoid server cached image

        System.out.println("\n\nworked\n\n");

    }
}

