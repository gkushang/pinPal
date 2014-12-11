package com.pinpal.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.pinpal.page.ProductPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductPageController
{

    private final PinPalService _pinPalService;

    @Autowired
    public ProductPageController
            (
                    PinPalService pinPalService
            )
    {

        _pinPalService = pinPalService;
    }

    @RequestMapping(value = {"/product/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {
        html.render(new ProductPage(_pinPalService));
    }


    @RequestMapping(value = {"/save-product/"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveProduct
            (
                    HttpServletRequest request
            ) throws IOException
    {
        _pinPalService.setDescription(request.getParameter("description"));
        _pinPalService.setManufacture(request.getParameter("manufacture_id"));
        _pinPalService.setItemName(request.getParameter("item_id"));
        _pinPalService.setSKU(request.getParameter("sku_id"));

    }


}

