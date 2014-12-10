package com.pinpal.controller;

import java.io.IOException;

import com.pinpal.page.ProductPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductPageController
{

    private final PinPalService _projectService;

    @Autowired
    public ProductPageController
            (
                    PinPalService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/product/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {
        html.render(new ProductPage(_projectService));
    }
}

