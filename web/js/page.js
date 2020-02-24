function back(){
    window.open('FindListServlet');
}


function jiancha(){
	let time = document.getElementById("time").value;
    let date = new Date();
    let year = date.getFullYear();
    let month = ('0' + (date.getMonth() + 1)).slice(-2);
    let day = ('0' + date.getDate()).slice(-2);
    let nowDate = year + '-' + month + '-' +day;
    
    let ttt = new Date(time);
    
    if(ttt<=date)
    {
        alert("请选择正确的时间！");
        document.getElementById("time").value = nowDate;
    }
    console.log(time);
}