package com.pinpal.service.project;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;


@Service
public class PinPalServiceImpl implements PinPalService
{

    private byte[] imageBytes;

    @Override
    public void setImageBytes(byte[] bytes)
    {
        this.imageBytes = bytes;
    }

    @Override
    public String getImageBytes()
    {
        if (imageBytes != null)
        {
            BASE64Encoder encoder = new BASE64Encoder();
            return "data:image/jpeg;base64," + encoder.encode(imageBytes);
        }

        return StringUtils.EMPTY;

    }
}
