var memberForm = document.getElementById("mf");
var userId = document.getElementById("userId");
var userPw = document.getElementById("userPw");
var userPw2 = document.getElementById("mpw2");
var username = document.getElementById("username");
var age = document.getElementById("age");
var email = document.getElementById("email");


/**
* 회원가입 PART
*/
function register(){
    var e = window.event;
    e.preventDefault();
    var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    if(userId.value.trim() === "1"){
        alert("아이디를 입력해주세요.");
        userId.focus();
        return;
    } else if (userPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요");
        userPw.focus();
        return;
    } else if(userPw.value.trim() != userPw2.value.trim()){
        alert("비밀번호가 일치하지 않습니다.");
        userPw2.focus();
        return;
    }
    /* else if(age.value.trim() == "" || isNaN(age.value)){
        alert("사용자 나이를 확인해주세요.");
        age.focus();
        return;
    }*/
    else if(username.value.trim() == "" || !isNaN(username.value)){
        alert("사용자 이름을 확인해주세요.");
    } else if(email.value == ""){
        alert("이메일을 입력해주세요.");
        email.focus();
        return;
    } else if(!emailRegex.test(email.value)){
        alert("올바른 이메일 형식을 사용해주세요.");
        email.focus();
        return;
    } else{
        memberForm.submit();
    }
}
document.getElementById("joinOkBtn").addEventListener("click", register());


/*
* 아이디 중복체크 PART
*/
var ischeckedId = false;

function idck() {
  var id = document.getElementById("userId");

  if (id.value == "") {
    alert("아이디를 입력해주세요.");
    id.focus();
  } else {
    fetch(`../member/check-userId/${id.value}`, {
      method: "GET",
    })
    .then(response => response.text())
    .then(data => {
    console.log(data);
      if (data === "canuse") {
        alert("사용가능한 아이디 입니다.");
        ischeckedId = true;
        id.readOnly = true;
      } else if (data === "nouse") {
        alert("이미 사용중인 아이디입니다.");
      }
    })
    .catch(error => {
      console.error("Error during username check:", error);
    });
  }
}