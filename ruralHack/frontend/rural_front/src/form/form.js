let button = document.getElementById("btnRegister");

button.addEventListener("click", (evento) => {
  registerGuest();
});

let registerGuest = async () => {
  let information = {};

  information.firstName = document.getElementById("firstname").value;
  information.lastName = document.getElementById("lastname").value;
  information.email = document.getElementById("email").value;
  information.birthDate = document.getElementById("birthdate").value;

  const request = await fetch("http://localhost:8080/guests", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(information),
  });
};