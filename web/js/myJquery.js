$(function(){
   $("#ddl").dblclick(function(){
      $("#ddl").attr("readOnly",false);
   });
});

$(function(){
   $("#ddl").blur(function(){
    $("#ddl").attr("readOnly","true");
   });
});

$(function(){
  $("#content").dblclick(function(){
     $("#content").attr("readOnly",false);
  });
});

$(function(){
  $("#content").blur(function(){
   $("#content").attr("readOnly","true");
  });
});



window.onload=function () {
    document.getElementById("chkAll").onclick=function () {
        var chkAll=document.getElementById("chkAll");
        var chk=document.getElementsByName("chk");
        for (var i=0;i<chk.length;i++){
            chk[i].checked=chkAll.checked;};

    }
    document.getElementById("remove").onclick=function () {
        var flag=false;
        var chk= document.getElementsByName("chk");
        for (var i=0;i<chk.length;i++){
            if (chk[i].checked){
                flag=true;

            }
        }
        if (flag=true){
            document.getElementById("form1").submit();
        }
    }



}






$(function(){
  var $table = $('table');  
  var currentPage = 0;//当前页默认值为0  
  var pageSize = 5;//每一页显示的数目  
  $table.bind('paging',function(){  
      $table.find('tbody tr').hide().slice(currentPage*pageSize,(currentPage+1)*pageSize).show();  
  });       
  var sumRows = $table.find('tbody tr').length;  
  var sumPages = Math.ceil(sumRows/pageSize);//总页数  
    
  var $pager = $('<br><div class="page"></div>');  //新建div，放入a标签,显示底部分页码  
  for(var pageIndex = 0 ; pageIndex<sumPages ; pageIndex++){  
      $('<a href="#" id="pageStyle" onclick="changCss(this)"><span>'+(pageIndex+1)+'</span></a>').bind("click",{"newPage":pageIndex},function(event){  
          currentPage = event.data["newPage"];  
          $table.trigger("paging");  
            //触发分页函数  
          }).appendTo($pager);  
          $pager.append(" ");  
      }     
      $pager.insertAfter($table);  
      $table.trigger("paging");  
        
      //默认第一页的a标签效果  
      var $pagess = $('#pageStyle');  
      $pagess[0].style.backgroundColor="rgb(21, 145, 218)";  
      $pagess[0].style.color="#ffffff";  
});

function changCss(obj){  
  var arr = document.getElementsByTagName("a");  
  for(var i=0;i<arr.length;i++){     
   if(obj==arr[i]){       //当前页样式  
    obj.style.backgroundColor="rgb(21, 145, 218)";  
    obj.style.color="#ffffff";  
   
  }  
   else  
   {  
     arr[i].style.color="";  
     arr[i].style.backgroundColor="";  
   }  
  }  
}      
