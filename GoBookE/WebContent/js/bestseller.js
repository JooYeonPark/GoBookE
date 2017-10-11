String.prototype.replaceAll = function(org, dest) {
        return this.split(org).join(dest);
    }
$(function() {
  $.ajax({
    url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=100",
    dataType : "xml",
    type: 'GET',
    success : function(res) {
      var myXML = res.responseText;
      xmlDoc=$.parseXML(myXML);
      var output = "";
      $(xmlDoc).find("item").each(function(index){
    	  var test=$(this).find("title").text();
    	  var title=test.replaceAll("&","%26").replaceAll("+","%2B");
        output += "<div class=\"col-md-3 col-sm-4\"><div class=\"product\">";
        output +="<div class=\"image\">";
        output +="<a href=\"/book/bestSellerDetail.do?categoryId=100&title="+title+"\">";
        /* output += "<img src="+$(this).find("coverLargeUrl").text()+"class=\"img-responsive image1\">"; */
        output += " <img  style=\"height: 280px; display: unset;\" class=\"img-responsive image1\" align=\"center\" src="+$(this).find("coverLargeUrl").text()+">";
        output +="</a>";
        output +="</div>";
        output +="<div class=\"text\">";
        output +="<h3><a href=\"/book/bestSellerDetail.do?categoryId=100&title="+title+"\">";
        output +=$(this).find("title").text();
        output +="</a></h3>";
        output +="<p class=\"price\">가격:"+$(this).find("priceStandard").text()+"</p>";
        output +="<p class=\"buttons\"><a href=\"shop-detail.html\" class=\"btn btn-default\">View detail</a><a href=\"shop-basket.html\" class=\"btn btn-template-main\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a></p>";
        output +="</div>";
        output += "</div></div>";
        
        if(index==27){
        	return false;
        }
      });
      $("#internal").html(output);
      $(".image").css("height",280);
    }
  });
  
  $.ajax({
	    url : "http://book.interpark.com/api/bestSeller.api?key=AD05009D9D975D46B742B91DF4D0F5663FEC24E72F5BFCA7A16ED288A972F90C&categoryId=200",
	    dataType : "xml",
	    type: 'GET',
	    success : function(res) {
	      var myXML = res.responseText;
	      xmlDoc=$.parseXML(myXML);
	      var output = "";
	      $(xmlDoc).find("item").each(function(index){
	    	  var test=$(this).find("title").text();
        	  var title=test.replaceAll("&","%26").replaceAll("+","%2B");
	        output += "<div class=\"col-md-3 col-sm-4\"><div class=\"product\">";
	        output +="<div class=\"image\">";
	        output +="<a href=\"/book/bestSellerDetail.do?categoryId=200&title="+title+"\">";
	        /* output += "<img src="+$(this).find("coverLargeUrl").text()+"class=\"img-responsive image1\">"; */
	        output += " <img  style=\"height: 280px; display: unset;\" class=\"img-responsive image1\" align=\"center\" src="+$(this).find("coverLargeUrl").text()+">";
	        output +="</a>";
	        output +="</div>";
	        output +="<div class=\"text\">";
	        output +="<h3><a href=\"/book/bestSellerDetail.do?categoryId=200&title="+title+"\">";
	        output +=$(this).find("title").text();
	        output +="</a></h3>";
	        output +="<p class=\"price\">가격:"+$(this).find("priceStandard").text()+"</p>";
	        output +="<p class=\"buttons\"><a href=\"shop-detail.html\" class=\"btn btn-default\">View detail</a><a href=\"shop-basket.html\" class=\"btn btn-template-main\"><i class=\"fa fa-shopping-cart\"></i>Add to cart</a></p>";
	        output +="</div>";
	        output += "</div></div>";
	        if(index==27){
	        	return false;
	        }
	      });
	      $("#external").html(output);
	      $(".image").css("height",280);
	    }
	  });
  return false;
});