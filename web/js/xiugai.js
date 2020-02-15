function edit(obj,attrName){
	var old = obj.value;	
      obj.value= '';  
      obj.focus();  
  $(obj).blur (function(){
		if(this.value==null || this.value==""){
		 obj.value = old;
		   return false;
	   }
	   obj.value = this.value?this.value:old;
	   var userId = $("#userId").val();
		if(old != this.value){
		   $.ajax({
			   type:"post",
			   url:"",
			   dataType:"json",
			   data:{"attrName":attrName,"newHtml":this.value,"userId":userId},
			   error:function(){
			   },
			   success:function(){
				   
			   },
		   });
	   
	   }  
	   
   })
   
   
}