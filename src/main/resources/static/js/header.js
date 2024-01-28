function logoutMember() {
  var form = document.createElement("form");
  form.setAttribute("method", "POST");
  form.setAttribute("action", "/member/logout");
  document.body.appendChild(form);
  form.submit();
  document.body.removeChild(form);
}