package com.pinpal.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.pinpal.page.OfferPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OfferPageController
{

    private final PinPalService _projectService;

    @Autowired
    public OfferPageController
            (
                    PinPalService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/offer/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {
        html.render(new OfferPage(_projectService));
    }

    @RequestMapping(value = {"/save-offer/"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveProduct
            (
                    HttpServletRequest request
            ) throws IOException
    {
        System.out.println("\nSave here\n");
    }
}

