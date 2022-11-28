function escucharClickBoton(){

    const botonGuardar= document.getElementById("btn-guardar-gestor")
    botonGuardar.addEventListener("click",(_event)=>{

    console.log("Click!")
    const usuarioInput = document.querySelector("[name='usuario']")
    const correoInput = document.querySelector("[name='correo']")
    const passwordInput = document.querySelector("[name='password']")
    const imagenInput = document.querySelector("[name='imagen']")


        const nuevoGestor={
             usuario: usuarioInput.value,
             correo : correoInput.value,
             password : passwordInput.value ,
             imagenUrl: imagenInput.value
        }

        //si no le colocamos nada, al fetch pasaria un GET
        const opcionesPost = {
            method: "POST",
            body : JSON.stringify(nuevoGestor),
            headers: {"Content-type": "application/json"}
        }
    
        
        fetch('http://localhost:8080/gestor', opcionesPost).then(response=>response.json()).then(gestorGuardado =>{
        console.log({gestorGuardado})
        //limpiamos los inputs 
        usuarioInput.value=" "
        correoInput.value=" "
        passwordInput.value=" "
        imagenInput.value=" "
    })




    })
}
        //recargamos las lista de obtener gestores
        escucharClickBoton()