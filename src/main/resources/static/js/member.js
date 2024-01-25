var memberForm = document.getElementById("mf");
var userId = document.getElementById("userId");
var userPw = document.getElementById("userPw");
var userPw2 = document.getElementById("mpw2");
var username = document.getElementById("username");
var age = document.getElementById("age");
var email = document.getElementById("email");


function register(){
    var e = window.event;
    e.preventDefault();
    var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

    if(userId.value.trim() === ""){
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
    } else if(age.value.trim() == "" || isNaN(age.value)){
        alert("사용자 나이를 확인해주세요.");
        age.focus();
        return;
    } else if(username.value.trim() == "" || !isNaN(username.value)){
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

// 버튼 클릭 시 register 함수 호출
document.getElementById("joinOkBtn").addEventListener("click", register());
