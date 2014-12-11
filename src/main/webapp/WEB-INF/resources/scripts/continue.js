

jQuery(document).ready(function() {

        $(".continue-product").on('click',function() {


        var me = $(this);
        var description = $("#description").val();
        var manufacture_id = $("#manufacture-id").val();
        var item_id = $("#item-id").val();
        var sku_id = $("#sku-id").val();

             $.ajax({

                type: "POST",
                url: "/save-product/",
                data:{description:description,
                manufacture_id:manufacture_id,
                item_id:item_id,
                sku_id:sku_id}
                    }).done(function(data) {

                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-offer").on('click',function() {

        var me = $(this);
        var retailprice = $("#r-price-id").val();
        var discountpercentage = $("#d-perc-id").val();
        var discountprice = $("#d-price-id").val();
        var startdate = $("#s-date-id").val();
        var enddate = $("#e-date-id").val();
             $.ajax({

                type: "POST",
                url: "/save-offer/"
                data:{retailprice:retailprice,
                discountpercentage:discountpercentage,
                discountprice:discountprice,
                startdate:startdate,
                enddate:enddate
                }
                    }).done(function(data) {



                                                          });

            });
});


jQuery(document).ready(function() {

        $(".continue-pinit").on('click',function() {


        var me = $(this);

             $.ajax({

                type: "POST",
                url: "/pin-it-done/"

                    }).done(function(data) {

                    top.location.href = "/pin-it/";

                                                          });

            });
});