function logoutMember() {
  var form = document.createElement("form");
  form.setAttribute("method", "POST");
  form.setAttribute("action", "/member/logout");
  document.body.appendChild(form);
  form.submit();
  document.body.removeChild(form);
}


/** 회원정보 수정 PART **/
function member_edit(midx){
  var form = document.createElement("form");

  form.setAttribute("method", "POST");
  form.setAttribute("action", `/member/edit`);

  var input = document.createElement("input");
  input.setAttribute("name", "midx");
  input.setAttribute("value", midx);

  form.appendChild(input);

  document.body.appendChild(form);
  form.submit();
  document.body.removeChild(form);
}