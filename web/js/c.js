let num = document.getElementById("count").innerHTML;

function sj(){
    num--;
    document.getElementById("count").innerHTML = num;
    if(num==0)
    {
        location.assign("homepage.jsp");
    }
}

setInterval("sj()",1000);