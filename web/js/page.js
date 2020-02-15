function back(){
    window.open('FindListServlet');
}


function topic(){
    var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("topic").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","你要填的在这里！！这个是考核名",true);
	xmlhttp.send();
}

function ddl(){
    var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("ddl").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","你要填的在这里！！这个是截止时间",true);
	xmlhttp.send();
}

function content(){
    var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("content").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET","你要填的在这里！！这个是考核内容",true);
	xmlhttp.send();
}



function list(){
	  let stuJson=[];
	  $.ajax({
		  type:"post",
		  url:"这里也是要填的",
		  data:{},
		  async:false,
		  success:function (data) {
			  stuJson=data;
			  let str="";
			  str+="<tr>"+
				   "<td>"+stuJson.chk + "</td>"+
				   "<td>"+stuJson.xh + "</td>"+
				   "<td>"+stuJson.xm + "</td>"+
				   "<td>"+stuJson.tjsj+ "</td>"+
				   "<td>"+stuJson.wj + "</td>"+
				   "<td>"+stuJson.shr + "</td>"+
				   "<td>"+ stuJson.bj+ "</td>"+
				   "</tr>";

			document.getElementById("stu").innerHTML=str;
		  }
	  });
}

topic();
ddl();
content();
list();