package com.pinpal.service.project;

public interface PinPalService
{
    String getDescription();

    String getManufacture();

    String getItemName();

    String getSku();

    String getRetailPrice();

    String getDiscountPrice();

    String getDiscountPercentage();

    String getStartDate();

    String getEndDate();

    void setImageBytes(byte[] bytes);

    String getImage();

    void setDescription(String description);

    void setManufacture(String manufacture);

    void setItemName(String itemName);

    void setSKU(String sku);

    void setRetailPrice(String retailPrice);

    void setDiscountPrice(String discountPrice);

    void seDiscountPercentage(String discountPercentage);

    void setStartDate(String startDate);

    void setEndDate(String endDate);


}
