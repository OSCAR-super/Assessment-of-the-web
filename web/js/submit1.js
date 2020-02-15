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

    $(".input").remove();

    box.style.border = "3px dashed #2267ce";
    let files = e.dataTransfer.files;
    let size = files[0].size/1024/1024;
    console.log(files);
    
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

