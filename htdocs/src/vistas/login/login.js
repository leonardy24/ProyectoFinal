function escucharClickBotonLogin(){
   
   
   
    const botonLogin= document.getElementById("btn-login")

    botonLogin.addEventListener("click",(_event)=>{

      
    const correoInput = document.querySelector("[name='correo']")
    const passwordInput = document.querySelector("[name='password']")

    const query= `?correo=${correoInput.value}&password=${passwordInput.value}`


    fetch('http://localhost:8080/gestor/login' + query)
    .then(response =>response.json())
    .then(gestor =>{ 

        console.log({gestor})
     

        if(gestor!= null){
            sessionStorage.setItem("miUsuario", JSON.stringify(gestor))
            location.replace("/mi-perfil")
            alert("INICIASTE SESIÓN")
        }else{
            alert("USUARIO O CONTRASEÑA INCORRECTO")
        }


        })

    



    })


}

escucharClickBotonLogin()