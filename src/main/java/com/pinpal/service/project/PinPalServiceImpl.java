package com.pinpal.service.project;

import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;


@Service
public class PinPalServiceImpl implements PinPalService
{

    private byte[] imageBytes;


    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getManufacture()
    {
        return manufacture;
    }

    @Override
    public String getItemName()
    {
        return itemName;
    }

    @Override
    public String getSku()
    {
        return sku;
    }

    @Override
    public String getRetailPrice()
    {
        return retailPrice;
    }

    @Override
    public String getDiscountPrice()
    {
        return discountPrice;
    }

    @Override
    public String getDiscountPercentage()
    {
        return discountPercentage;
    }

    @Override
    public String getStartDate()
    {
        return startDate;
    }

    @Override
    public String getEndDate()
    {
        return endDate;
    }

    private String description;
    private String manufacture;
    private String itemName;
    private String sku;
    private String retailPrice;
    private String discountPrice;
    private String discountPercentage;
    private String startDate;
    private String endDate;

    @Override
    public void setImageBytes(byte[] bytes)
    {
        this.imageBytes = bytes;
    }

    @Override
    public String getImage()
    {
        if (imageBytes != null)
        {
            BASE64Encoder encoder = new BASE64Encoder();
            return "data:image/jpeg;base64," + encoder.encode(imageBytes);
        }

        return " ";
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public void setManufacture(String manufacture)
    {
        this.manufacture = manufacture;
    }

    @Override
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    @Override
    public void setSKU(String sku)
    {
        this.sku = sku;
    }

    @Override
    public void setRetailPrice(String retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    @Override
    public void setDiscountPrice(String discountPrice)
    {
        this.discountPrice = discountPrice;
    }

    @Override
    public void seDiscountPercentage(String discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }
}
