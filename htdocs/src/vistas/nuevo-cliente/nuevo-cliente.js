function escucharClickBotonCliente(){
    const botonGuardar=document.getElementById("boton-guarda-cliente")
    botonGuardar.addEventListener("click", (_event)=>{
        const idGestor=2

        console.log("clik!!!")
        const usuarioInput = document.querySelector("[name='usuario']")
        const correoInput = document.querySelector("[name='correo']")
        const passwordInput = document.querySelector("[name='password']")
        const saldoInput = document.querySelector("[name='saldo']")



        const nuevoCliente={
            usuario: usuarioInput.value,
            correo: correoInput.value,
            password: passwordInput.value,
            saldo: saldoInput.value,
            gestor: {
                id: idGestor
            }
        }


       //si no le colocamos nada, al fetch pasaria un GET
       const opcionesPost = {
        method: "POST",
        body : JSON.stringify(nuevoCliente),
        headers: {"Content-type": "application/json"}
    }


    fetch('http://localhost:8080/cliente' , opcionesPost).then(response=>response.json()).then(clienteGuardado =>{
        console.log({clienteGuardado})
        //limpiamos los inputs 
        usuarioInput.value=" "
        correoInput.value=" "
        passwordInput.value=" "
        saldoInput.value=" "
    })



    })
}
    escucharClickBotonCliente()