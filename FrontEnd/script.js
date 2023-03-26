const formulario = document.querySelector("form");
const Ilogin = document.querySelector(".login")
const Inome = document.querySelector(".nome")
const Isenha = document.querySelector(".senha")
const Iemail = document.querySelector(".email")
const Igenero = document.querySelector(".genero")
const Icpf = document.querySelector(".cpf")
const Icep = document.querySelector(".cep")
const Icelular = document.querySelector(".celular")

function cadastrar(){

    fetch("http://localhost:8080/cadastrar",
        {
            headers: {
                'Accept': 'applcation/json',
                'Content-Type': 'application/json'
            },
            method:"POST",
            body: JSON.stringify({
                login: Ilogin.value,
                nome: Inome.value,
                senha: Isenha.value,
                email: Iemail.value,
                genero: Igenero.value,
                cpf: Icpf.value,
                cep: Icep.value,
                celular: Icelular.value
            })
        })
        .then(function(res) {console.log(res)})
        .catch(function(res) {console.log(res)})    
};

function limpar() {
    Ilogin.value = "";
    Inome.value = "";
    Isenha.value = "";
    Iemail.value = "";
    Igenero.value = "";
    Icpf.value = "";
    Icep.value = "";
    Icelular.value = "";
}

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    
    cadastrar();
    limpar();
});
