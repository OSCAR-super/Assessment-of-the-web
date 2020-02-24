function list(){
    let taskJson=[];
    $.ajax({
        type:"post",
        url:"这里也是要填的",
        data:{},
        async:false,
        success:function (data) {
            taskJson=data;
            let str="";
            str+="<tr>"+
                 "<td>"+taskJson.chk + "</td>"+
                 "<td>"+taskJson.khm + "</td>"+
                 "<td>"+taskJson.ddl + "</td>"+
                 "<td>"+taskJson.link+ "</td>"+
                 "</tr>";

          document.getElementById("task").innerHTML=str;
        }
    });
}




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




function zj()
{
    window.open("zengjia1.jsp");
}

function add1()
{
  let i=$("#task").find("tr").length;
 let row = document.getElementById("table").insertRow(i+1);
 let l1 = row.insertCell(0);
 let l2 = row.insertCell(1);
 let l3 = row.insertCell(2);
 let l4 = row.insertCell(3);
 let l5 = row.insertCell(4);
 l1.innerHTML = "<input type='checkbox' name='chk' >";
 l4.innerHTML = "<a href='${pageContext.request.contextPath}/FindStudentByConditionServlet'>查看详情</a>";
l5.innerHTML = " <input type='button' value='修改' onclick='xg()' id='x'>";
}

list();