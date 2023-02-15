<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Web Programing</h1>
<input id="in" /><button id="btn">클릭</button>
<ul id="itemList">
<li>HTML</li>
<li>CSS</li>
<li>JS</li> 
</ul>
<script>
btn.addEventListener("click",function(){
    var inT = document.getElementById("in").value; //변수 inT
    var txNode = document.createTextNode(inT);
    var newLi = document.createElement("li");
    newLi.appendChild(txNode);
    var orgLi = document.getElementById("itemList");
    orgLi.appendChild(newLi);
});
//var newP = document.createElement("li");
//var txNode = document.createTextNode("테스트");
//newP.appendChild(txNode);
//document.getElementById("itemList").appendChild(newP);
//alert("반갑습니다"); //페이지 뜨기 전에 arert창 뜸

//console.log("Hello!"); // 콘솔에 찍어 줌

//var reply = confirm("yes?"); // 변수를 
//console.log(reply);  // 창에서 확인 누르면 true , 취소 누르면 false

//var name = prompt("이름은?", "디폴트"); // 입력 안 하면 디폴트
//console.log(name); 
//document.write(name); //웹 페이지에 나옴



</script>
</body>
</html>