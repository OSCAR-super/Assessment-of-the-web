function back(){
    window.open("homepage.jsp");
}

function login(){
    window.open("login.jsp");
}

var box = document.getElementById('post'); //拖拽区域     
box.addEventListener("drop",function (e){
    e.stopPropagation();
    e.preventDefault();

  

    box.style.border = "3px dashed #2267ce";
    let files = e.dataTransfer.files;
    let size = files[0].size/1024/1024;
    console.log(files[0].name);

    let nnn = files[0].name;
    let index = nnn.lastIndexOf(".");
    let leixing = nnn.substring(index+1,nnn.length);
    console.log(leixing);
    
    if(leixing!="zip")
    {
        alert("只能上传zip！");
        return
    }
    $(".input").remove();
    let add = $('<input class="input" type="file" name="file">  <span id="sss"></span>');
    $("#post").append(add);
    $(".input")[0].files = files;
   document.getElementById("sss").innerText =size.toFixed(2)+"MB";
    console.log($(".input")[0].files[0]);
   
},false);

document.addEventListener("dragover",function(e){
    e.stopPropagation();
    e.preventDefault();
    let x = document.getElementById("post");
    x.style.border = "3px dashed red";
},false);



$(".input").on('change',function(){
    let file = document.getElementsByClassName("input")[0].files[0].name;
    console.log(file);
    let index = file.lastIndexOf(".");
    let leixing = file.substring(index+1,file.length);
    console.log(leixing);
    
    if(leixing!="zip")
    {
        alert("只能上传zip！");
        $(".input")[0].value="";
    }
})
